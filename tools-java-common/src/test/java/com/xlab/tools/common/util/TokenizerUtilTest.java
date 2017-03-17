package com.xlab.tools.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.xlab.tools.common.tokenizer.TokenizerUtil;

public class TokenizerUtilTest {

	@Test
	public void testToStrArray() {
		String str = "";
		String[] strArray2 = TokenizerUtil.toStrArray(str);
		System.out.println(Arrays.toString(strArray2));
		String []ret = {};
		assertArrayEquals("fail", ret, strArray2);
		str = null;
		assertNull("fail", TokenizerUtil.toStrArray(str));
		
		str = "shosjsg";
		String[] strArray = TokenizerUtil.toStrArray(str);
		assertTrue("fail", strArray.length==str.length());
		System.out.println(Arrays.toString(strArray));
	}

	@Test
	public void testToWordArray() {//ANSJ 分词粒度有点粗,比如中华人民共和国一个词
		String str = "张三李四";
		String[] strArray2 = TokenizerUtil.toWordArray(str);
		System.out.println(Arrays.toString(strArray2));
		
		str = "转本年利润到未分配利润那一笔不用做凭证吗？ 系统是不是自动生成，因为我做了，但在系统中查不到这一笔";
		String[] strArray3 = TokenizerUtil.toWordArray(str);
		System.out.println(Arrays.toString(strArray3));
		
		str = "转本年利润到未分配利润那一笔不用做凭证吗？ 系统是不是自动生成，因为我做了，但在系统中查不到这一笔";
		String[] strArray4 = TokenizerUtil.toWordArray(str);
		System.out.println(Arrays.toString(strArray4));
	}
	@Test
	public void testToWordArray2() {//ANSJ 分词粒度有点粗,比如中华人民共和国一个词
		String strs[] = {"好人好事","日本和服装起来","中华人民共和国"};
		for(String str:strs){
			String[] strArray2 = TokenizerUtil.toWordArray(str);
			System.out.println(Arrays.toString(strArray2));
			
			String[] strArray3 = TokenizerUtil.toWordArrayTo(str);
			System.out.println(Arrays.toString(strArray3));
			
			String[] strArray4 = TokenizerUtil.toWordArrayIndex(str);
			System.out.println(Arrays.toString(strArray4));
			
			String[] strArray5 = TokenizerUtil.toWordArrayBase(str);
			System.out.println(Arrays.toString(strArray5));
		}
	}
	//
}
