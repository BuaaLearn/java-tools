package com.xlab.tools.common.io.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import com.xlab.tools.common.io.BaseMapLineReader;

/**
 * <p>
 * map结构的文件行阅读器
 * </p>
 */
public class FileMapLineReader<K, V> extends BaseMapLineReader<K, V> {


    @Override
    protected BufferedReader getReader(String filename) throws UnsupportedEncodingException,
            FileNotFoundException {
        InputStream input = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,
                "UTF-8"));
        return reader;
    }

}
