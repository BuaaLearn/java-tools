package com.xlab.tools.common.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import com.xlab.tools.common.logger.LogUtil;

/**
 * <p>
 * 基础文件的读写
 * </p>
 */
public abstract class BaseMapLineReader<K, V> {

    private Logger log = LogUtil.getCommonLogger();

    /**
     * 
     * @param filename
     * @param processor
     * @return
     * @throws Exception
     */
    public Map<K, V> readByLines(String filename, LineMapProcessor<K, V> processor) {
        Map<K, V> map = new LinkedHashMap<>();
        BufferedReader br = null;
        String line = null;
        try {
            br = getReader(filename);
            while (null != (line = br.readLine())) {
                if (line != null && !line.isEmpty()) {
                    Pair<K, V> d = processor.process(line);
                    if (d != null) {
                        map.put(d.getKey(), d.getValue());
                    }
                }
            }
        } catch (IOException e) {
            log.error("load fail..." + filename, e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("close  fail..." + filename, e);
                }
            }
        }
        return map;
    }

    /**
     * 获得缓存流的读写
     * 
     * @param filename
     * @return
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     */
    protected abstract BufferedReader getReader(String filename)
            throws UnsupportedEncodingException, FileNotFoundException;
}
