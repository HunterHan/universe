package com.laiwu.source.code.string;

public class StringPlusPreCompile {

	/**
	 * String string1 = "a" + "b" + "c";
	 * 
	 * 在编译期间被优化为 String string1 = "abc";
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean compareStringPlus(String string1, String string2) {
		return (string1 == string2);
	}
}
