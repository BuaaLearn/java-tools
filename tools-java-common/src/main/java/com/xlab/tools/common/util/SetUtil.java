package com.xlab.tools.common.util;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 集合的实用类
 * </p>
 */
public class SetUtil {

	/** 
	 * <p>
	 * 两个集合的交集
	 * </p>
	 * @param setA
	 * @param sentB
	 * @return
	 */
	public static Set<String> intersect(Set<String> setA, Set<String> setB) {
		Set<String> tmp = new HashSet<>(setA);
		tmp.retainAll(setB);
		return tmp;
	}

	/** 
	 * <p>
	 * 两个集合的并集
	 * </p>
	 * @param setA
	 * @param sentB
	 * @return
	 */
	public static Set<String> union(Set<String> setA, Set<String> setB) {
		Set<String> tmp = new HashSet<>(setA);
		tmp.addAll(setB);
		return tmp;
	}
}
