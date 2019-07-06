package config.redis;

import java.util.Map;
import java.util.Set;

public interface JedisTemplateService<K, V> {

    boolean set(K key, V value);

    boolean set(K key, V value, long expire);

    V get(K key);

    boolean hmSet(K key, Object hashKey, Object value);

    boolean hmSet(K key, Map<Object, Object> map);

    Object hmGet(K key, Object hashKey);

    Map<Object, Object> hmGet(K key);

    boolean lPush(K key, V value);

    boolean rPush(K key, V value);

    V lPop(K key);

    V rPop(K key);

    V blPop(K key, long l);

    V brPop(K key, long l);

    boolean sAdd(K key, V ... value);

    Set<V> sGet(K key);

    Long increment(final K key);
}
