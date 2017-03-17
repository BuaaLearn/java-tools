package com.xlab.tools.common.io.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.xlab.tools.common.io.BaseLineReader;


/**
 * <p>
 * 资源文件的读写操作
 * </p>
 */
public class ResourceLineReader<D> extends BaseLineReader<D> {


    @Override
    protected BufferedReader getReader(String filename) throws UnsupportedEncodingException {
        BufferedReader br;
        InputStream is = ResourceLineReader.class.getClassLoader().getResourceAsStream(filename);
        br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        return br;
    }

}
