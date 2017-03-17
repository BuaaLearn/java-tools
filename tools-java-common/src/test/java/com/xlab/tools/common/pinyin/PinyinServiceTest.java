package com.xlab.tools.common.pinyin;


import org.junit.Test;

public class PinyinServiceTest {

    @Test
    public void testGetCommonPinyin() {
        String reg = " ";
        String str = "中国人民解放军";
        String commonPinyin = SimplePinyinService.getCommonPinyin(str, reg);
        System.out.println("commonPinyin:"+commonPinyin);
    }

}
