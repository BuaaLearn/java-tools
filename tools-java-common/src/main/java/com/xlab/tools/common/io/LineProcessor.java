package com.xlab.tools.common.io;

/**
 * <p>
 * 行读取操作
 * </p>
 */
public interface LineProcessor<D> {

    /**
     * @param line
     * @return
     */
    D process(String line);

}
