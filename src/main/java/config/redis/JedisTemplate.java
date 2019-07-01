package config.redis;

public interface JedisTemplate<K, V> {

    boolean set(K key, V value);

    boolean set(K key, V value, long expire);

    V get(K key);
}
