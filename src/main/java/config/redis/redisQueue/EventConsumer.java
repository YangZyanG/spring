package config.redis.redisQueue;

import config.redis.JedisTemplateService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer implements InitializingBean, ApplicationContextAware {

    @Autowired
    private JedisTemplateService jedisTemplateService;

    public void afterPropertiesSet() throws Exception {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
