package config.redis.redisQueue;

import com.alibaba.fastjson.JSONObject;
import config.redis.EventHandlerService;
import config.redis.JedisTemplateService;
import entity.redis.EventType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class EventConsumer implements InitializingBean, ApplicationContextAware {

    @Autowired
    private JedisTemplateService jedisTemplateService;
    @Autowired
    private ThreadPoolExecutor executor;

    private ApplicationContext applicationContext;
    private Map<EventType, EventHandlerService> handlers = new HashMap<EventType, EventHandlerService>(8);

    public void afterPropertiesSet() throws Exception {
        Map<String, EventHandlerService> handlerBeans = applicationContext.getBeansOfType(EventHandlerService.class);
        if(null != handlerBeans){
            for (Map.Entry<String, EventHandlerService> entry : handlerBeans.entrySet()){
                handlers.put(entry.getValue().getEventType(), entry.getValue());
            }
        }

        executor.execute(new Runnable() {
            public void run() {
                while (true){
                    String json = (String) jedisTemplateService.brPop("event", 0);
                    EventModel model = JSONObject.parseObject(json, EventModel.class);
                    if (handlers.containsKey(model.getEventType())){
                        handlers.get(model.getEventType()).doHandle(model);
                    }
                }
            }
        });
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
