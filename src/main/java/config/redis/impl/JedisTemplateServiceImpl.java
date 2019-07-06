package config.redis.impl;

import config.redis.JedisTemplateService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository("jedisTemplate")
public class JedisTemplateServiceImpl<K, V> implements JedisTemplateService<K, V> {

    @Autowired
    private RedisTemplate<K, V> redisTemplate;

//    private RedisConnectionFactory factory;
//    private RedisConnection connection;

//    public void afterPropertiesSet() throws Exception {
//        factory = redisTemplate.getConnectionFactory();
//        connection = factory.getConnection();
//    }

    public boolean set(final K key, V value) {
        boolean r = false;

        try {
            ValueOperations<K, V> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            r = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public boolean set(final K key, V value, long expire) {
        boolean r = false;

        try{
            ValueOperations<K, V> operations = redisTemplate.opsForValue();
            operations.set(key, value, expire);
            r = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public V get(final K key) {
        ValueOperations<K, V> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    public boolean hmSet(final K key, Object hashKey, Object value) {
        boolean r = false;

        try {
            HashOperations<K, Object, Object> operations = redisTemplate.opsForHash();
            operations.put(key, hashKey, value);
            r = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public boolean hmSet(final K key, Map<Object, Object> map) {
        boolean r = false;

        try{
            HashOperations<K, Object, Object> operations = redisTemplate.opsForHash();
            operations.putAll(key, map);
            r = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public Object hmGet(final K key, Object hashKey) {
        HashOperations<K, Object, Object> operations = redisTemplate.opsForHash();
        return operations.get(key, hashKey);
    }

    public Map<Object, Object> hmGet(final K key) {
        HashOperations<K, Object, Object> operations = redisTemplate.opsForHash();
        return operations.entries(key);
    }

    public boolean lPush(final K key, V value) {
        boolean r = false;

        try{
            ListOperations<K, V> operations = redisTemplate.opsForList();
            operations.leftPush(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public boolean rPush(final K key, V value) {
        boolean r = false;

        try {
            ListOperations<K, V> operations = redisTemplate.opsForList();
            operations.rightPush(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public V lPop(final K key) {
        ListOperations<K, V> operations = redisTemplate.opsForList();
        return operations.leftPop(key);
    }

    public V rPop(final K key) {
        ListOperations<K, V> operations = redisTemplate.opsForList();
        return operations.rightPop(key);
    }

    public V blPop(K key, long l) {
        ListOperations<K, V> operations = redisTemplate.opsForList();
        return operations.leftPop(key, l, TimeUnit.SECONDS);
    }

    public V brPop(K key, long l) {
        ListOperations<K, V> operations = redisTemplate.opsForList();
        return operations.rightPop(key, l, TimeUnit.SECONDS);
    }

    public boolean sAdd(final K key, V ... value) {
        boolean r = false;

        try{
            SetOperations<K, V> operations = redisTemplate.opsForSet();
            operations.add(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }

        return r;
    }

    public Set<V> sGet(K key) {
        SetOperations<K, V> operations = redisTemplate.opsForSet();
        return operations.members(key);
    }

    public Long increment(final K key){
        ValueOperations<K, V> operations = redisTemplate.opsForValue();
        return operations.increment(key);
    }

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
