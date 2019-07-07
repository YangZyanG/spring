import config.redis.JedisTemplateService;
import config.redis.redisQueue.EventModel;
import config.redis.redisQueue.EventProducer;
import entity.redis.EventType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

//    public static void main(String[] args) {
//
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
//        final JedisTemplateService jedis = (JedisTemplateService) applicationContext.getBean("jedisTemplate");
//
//        for (int i=0; i<10; ++i){
//
//            new Thread(){
//
//                public void run(){
//                    for (int i=0; i<100; ++i){
//                        System.out.println(jedis.increment("total"));
//                    }
//                }
//
//            }.start();
//
//        }
//
//    }

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

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");

        Thread.currentThread().sleep(5000);
        Map<String, String> map = new HashMap<String, String>();
        map.put("articleName", "测试文章");
        map.put("comment", "你在逗我吗？");

        EventProducer eventProducer = (EventProducer) applicationContext.getBean("eventProducer");
        EventModel model = new EventModel(EventType.COMMENT);
        model.setTriggerId("1");
        model.setReceiverId("2");
        model.setExtraInfo(map);

        eventProducer.pushEvent(model);
    }

    @Test
    public void txRedis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
        JedisTemplateService jedisTemplate = (JedisTemplateService) applicationContext.getBean("jedisTemplate");

        RedisTemplate template = jedisTemplate.getTemplate();
        template.execute(new SessionCallback<List<Object>>() {

            public List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
                //开启事务
                redisOperations.multi();

                redisOperations.opsForValue().set("tx1", "1");
                //模拟异常
                int i = 1/0;
                redisOperations.opsForValue().set("tx2", "2");

                //提交事务
                return redisOperations.exec();
            }

        });
    }
}
