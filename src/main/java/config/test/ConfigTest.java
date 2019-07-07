package config.test;

import config.redis.JedisTemplateService;
import config.thread.ThreadPool;
import entity.redis.EventType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

public class ConfigTest {

    @Test
    public void redis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
        JedisTemplateService jedisTemplate = (JedisTemplateService) applicationContext.getBean("jedisTemplate");
//        jedisTemplate.set("2", "2");
//
//        Teacher teacher = new Teacher();
//        jedisTemplate.set("teacher", teacher);
//        ((Teacher) jedisTemplate.get("teacher")).showMe();

//        jedisTemplate.hmSet("hash", "name", "yangzy");
//        System.out.println(jedisTemplate.hmGet("hash", "name"));
//
//        Map map = jedisTemplate.hmGet("hash");
//        System.out.println(map);

//        jedisTemplate.lPush("list", 1);
//        jedisTemplate.rPush("list", 2);
//        jedisTemplate.lPush("list", 3);
//        System.out.println(jedisTemplate.rPop("list"));

//        jedisTemplate.sAdd("set", 1, 2, 3);
//        System.out.println(jedisTemplate.sGet("set"));
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
        final JedisTemplateService jedis = (JedisTemplateService) applicationContext.getBean("jedisTemplate");

        for (int i=0; i<10; ++i){

            new Thread(){

                public void run(){
                    for (int i=0; i<100; ++i){
                        System.out.println(jedis.increment("total"));
                    }
                }

            }.start();

        }

    }

    @Test
    public void thread() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
        ThreadPoolExecutor executor = (ThreadPoolExecutor) applicationContext.getBean("threadPoolExecutor");
        System.out.println(executor);
    }

    @Test
    public void enumTest(){
        System.out.println(EventType.COMMENT);
    }
}