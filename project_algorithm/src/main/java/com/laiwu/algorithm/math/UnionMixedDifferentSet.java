package com.laiwu.algorithm.math;

import java.util.HashSet;
import java.util.Set;

public class UnionMixedDifferentSet {

	/**
	 * 【用于数学中的并集运算的算法】
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static Set<Integer> getUnionSet(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> result = new HashSet<Integer>();
		result.addAll(set1);
		result.addAll(set2);
		return result;
	}

	/**
	 * 【用于数学中的交集运算的算法】
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static Set<Integer> getMixedSet(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> result = new HashSet<Integer>();
		result.addAll(set1);
		result.retainAll(set2);
		return result;
	}

}
