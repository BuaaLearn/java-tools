package com.xlab.tools.common.util;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ChineseUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String input;
		String output;
		String tmp;

		input = "ＡＢＣ";
		output = "ABC";
		tmp = ChineseUtil.transDoubleToSingle(input);
		assertEquals(true, output.equals(tmp));

		input = "ABC";
		output = "ＡＢＣ";
		tmp = ChineseUtil.transSingleToDouble(input);
		assertEquals(true, output.equals(tmp));
	}
	
	/**
	 * 测试汉字数转换成数字
	 */
	@Test
	public void testTrans() {
		String text = "一千一百壹拾元";
	
		double defaultQuantifier = 10d;
		double result = ChineseUtil.transCnToDouble(text,defaultQuantifier  );
		assertEquals(0,Double.compare(1110, result));
		System.out.println(result);

		text = "一千四百";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(1400, result));
		System.out.println(result);
		
		text = "一千四";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(1400, result));
		System.out.println(result);
		
		text = "一万";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(10000, result));
		System.out.println(result);
		
		text = "一万零五十";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(10050, result));
		System.out.println(result);
		
		text = "一万零五百";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(10500, result));
		System.out.println(result);
		
		text = "一万五";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(15000, result));
		System.out.println(result);
		
		text = "二十三万五千";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(235000, result));
		System.out.println(result);
		
		text = "两千";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(2000, result));
		System.out.println(result);
		
		text = "35万一千";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(351000, result));
		System.out.println(result);
		
		text = "一千六";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(1600, result));
		System.out.println(result);

		text = "八百五";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(850, result));
		System.out.println(result);
		
		text = "七千零二百";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(7200, result));
		System.out.println(result);
		
		text = "七万零二百";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(70200, result));
		System.out.println(result);
		
		text = "一万三千二";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(13200, result));
		System.out.println(result);
		
		text = "三万零四百";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(30400, result));
		System.out.println(result);
		
		text = "55000";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(55000, result));
		System.out.println(result);

		text = "四千";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(4000, result));
		System.out.println(result);
		text = "三千三百六";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(3360, result));
		System.out.println(result);

		text = "68760";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(68760, result));
		System.out.println(result);
		
		text = "叄元";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(3, result));
		System.out.println(result);
		

		text = "六亿九千万";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(690000000, result));
		System.out.println(result);
		
		text = "拾元五毛六分";
		result = ChineseUtil.transCnToDouble(text,defaultQuantifier);
		assertEquals(0,Double.compare(10.56, result));
		System.out.println(result);

	}

	/**
	 * 测试中文汉字
	 */
	@Test
	public void testChSimple() {
		char ch;
		boolean r;
		ch = '我';
		r = ChineseUtil.isChSimple(ch);
		assertTrue(r);
		r = ChineseUtil.isChTraditional(ch);
		assertTrue(r);
		ch = '無';
		r = ChineseUtil.isChSimple(ch);
		assertFalse(r);
		r = ChineseUtil.isChTraditional(ch);
		assertTrue(r);
		
		ch='蜗';
		assertTrue(ChineseUtil.isChSimple(ch));
		assertFalse(ChineseUtil.isChTraditional(ch));
		
		ch='蝸';
		assertTrue(ChineseUtil.isChTraditional(ch));
		assertFalse(ChineseUtil.isChSimple(ch));
	}
}
