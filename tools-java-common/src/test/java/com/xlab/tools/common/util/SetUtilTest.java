package com.xlab.tools.common.util;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetUtilTest {

	@Test
	public void testIntersect() {
		Set<String> setA = new HashSet<>();
		setA.add("B");
		setA.add("C");
		setA.add("D");
		Set<String> setB = new HashSet<>();
		setB.add("A");
		setB.add("B");
		setB.add("C");
		Set<String> intersect = SetUtil.intersect(setA, setB);
		 assertTrue("fail", intersect.contains("B"));  
		 assertTrue("fail", intersect.contains("C"));  
		 assertFalse("fail", intersect.contains("A"));  
//		assertThat(actual, matcher);
	}
	
	
	@Test
	public void testUnion() {
		Set<String> setA = new HashSet<>();
		setA.add("B");
		setA.add("C");
		setA.add("D");
		Set<String> setB = new HashSet<>();
		setB.add("A");
		setB.add("B");
		setB.add("C");
		Set<String> unionSet = SetUtil.union(setA, setB);
		 assertTrue("fail", unionSet.contains("B"));  
		 assertTrue("fail", unionSet.contains("C"));  
		 assertTrue("fail", unionSet.contains("A"));  
		 assertTrue("fail", unionSet.contains("D"));  
	}
	
}
