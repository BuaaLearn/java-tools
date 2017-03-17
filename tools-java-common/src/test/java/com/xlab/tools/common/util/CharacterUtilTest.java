package com.xlab.tools.common.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CharacterUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(0, CharacterUtil.identifyCharType('+'));
		assertEquals(1, CharacterUtil.identifyCharType('7'));
		assertEquals(2, CharacterUtil.identifyCharType('a'));
		assertEquals(2, CharacterUtil.identifyCharType('A'));
		assertEquals(2, CharacterUtil.identifyCharType('-'));
		assertEquals(4, CharacterUtil.identifyCharType('我'));
		assertEquals(8, CharacterUtil.identifyCharType('こ'));
		assertEquals(0, CharacterUtil.identifyCharType(';'));
		
		assertEquals('4', CharacterUtil.regularize('４'));
		assertEquals('a', CharacterUtil.regularize('A'));
	}

}
