package config.redis.redisQueue;

import com.alibaba.fastjson.JSONObject;
import config.redis.JedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    @Autowired
    JedisTemplateService jedisTemplateService;

    private static final String EVENT_QUEUE_KEY = "event";

    public void pushEvent(EventModel model){

        String event = JSONObject.toJSONString(model);
        jedisTemplateService.lPush(EVENT_QUEUE_KEY, event);

    }
}
