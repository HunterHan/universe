package com.laiwu.algorithm.math;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	/**
	 * 【获取从0到range范围内的所有素数的算法, 素数是只能被1和本身整除的正整数。】
	 * 
	 * @param range
	 * @return
	 */
	public static List<Integer> getPrime(int range) {
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < range; i++) {
			primes.add(i);
			for (int j = 2; j <= i >> 1; j++) {
				if (i % j == 0) {
					primes.remove(new Integer(i));
					break;
				}
			}
		}
		return primes;
	}
}
