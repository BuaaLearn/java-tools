package com.xlab.tools.common.io;

public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    /**
     * 获得key值
     * @return
     */
    public K getKey() {
        return key;
    }
    /**
     * 获得value
     * @return
     */
    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
