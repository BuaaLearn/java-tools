package com.xlab.tools.common.io.impl;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import com.xlab.tools.common.io.BaseLineReader;

/**
 * <p>
 * 文件行阅读器
 * </p>
 */
public class FileLineReader<D>  extends BaseLineReader<D>{


    @Override
    protected BufferedReader getReader(String filename) throws UnsupportedEncodingException, FileNotFoundException {
        InputStream input = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,
                "UTF-8"));
        return reader;
    }

}
