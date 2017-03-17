package com.xlab.tools.common.io;

/**
 * <p>
 * 键值对的行读取操作
 * </p>
 */
public interface LineMapProcessor<K, V> {

    /**
     * @param line
     * @return
     */
    Pair<K, V> process(String line);

}
