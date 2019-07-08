package aware;

import config.redis.EventHandlerService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/***
 * ApplicationContextAware用于获取ApplicationContext实例，ApplicationContext也可以获取到容器中所有的bean，并有多种获取方式。
 * ApplicationContext拥有BeanFactory的全部功能。
 */
public class ApplicationContextAwareBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void getBeans(){
        Map<String, EventHandlerService> map = applicationContext.getBeansOfType(EventHandlerService.class);
        for (Map.Entry<String, EventHandlerService> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
