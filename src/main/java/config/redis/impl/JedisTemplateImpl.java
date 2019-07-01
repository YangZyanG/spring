package config.redis.impl;

import config.redis.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository("jedisTemplate")
public class JedisTemplateImpl<K, V> implements JedisTemplate<K, V> {

    @Autowired
    private RedisTemplate<K, V> redisTemplate;

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

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
