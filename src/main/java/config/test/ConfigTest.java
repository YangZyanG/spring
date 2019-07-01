package config.test;

import bean.Teacher;
import config.redis.JedisTemplate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");

    @Test
    public void redis(){
        JedisTemplate jedisTemplate = (JedisTemplate) applicationContext.getBean("jedisTemplate");
        jedisTemplate.set("2", "2");

        Teacher teacher = new Teacher();
        jedisTemplate.set("teacher", teacher);
        ((Teacher) jedisTemplate.get("teacher")).showMe();
    }
}
