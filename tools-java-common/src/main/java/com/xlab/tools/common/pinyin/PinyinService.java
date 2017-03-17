/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.common.pinyin;

import java.util.HashMap;
import java.util.Map;

import com.xlab.tools.common.io.LineMapProcessor;
import com.xlab.tools.common.io.Pair;
import com.xlab.tools.common.io.impl.ResourceMapLineReader;
import com.xlab.tools.common.util.StringUtil;

/**
 * <p>
 * 拼音相关服务
 * </p>
 * @author towan  
 */
public class PinyinService {
   
    private static Map<String, String> ch2Pinyin = new HashMap<>();
    static{
        initResource("Chinese2Pinyin.txt");
    }
    /**
     * 获取常见的拼音(多音选择第一个)
     * @param text
     * @return
     */
    public static String getCommonPinyin(String text, String reg){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<text.length();i++){
            String substring = text.substring(i, i+1);
            String pinyin = ch2Pinyin.get(substring)==null?substring:ch2Pinyin.get(substring);
            sb.append(pinyin).append(reg);
        }
        String ret = sb.substring(0, sb.toString().length()-reg.length());
        return ret;
    }
    /**
     * 初始资源加载
     * @param filename
     */
    private static void initResource(String filename) {
        
        ResourceMapLineReader<String, String> reader = new ResourceMapLineReader<>();
        ch2Pinyin =
                reader.readByLines(filename, new LineMapProcessor<String, String>() {
                    @Override
                    public Pair<String, String> process(String line) {
                        if(StringUtil.isEmpty(line)){
                            return null;
                        }
                        String[] lines = line.split("-->");
                        if (lines.length <= 1) {
                            return null;
                        } else {
                            return new Pair<String, String>(lines[0],
                                    lines[1]);
                        }
                    }
                });
        
    }
}
