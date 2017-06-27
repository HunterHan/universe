package test.java.lang;

import org.junit.Test;

import com.laiwu.source.code.string.StringPlusPreCompile;

public class StringTest {

	/**
	 * String 的 + 在编译器被优化的验证
	 */
	@Test
	public void compareStringPlusTest() {
		String string1 = "a" + "b" + "c";
		String string2 = "abc";
		boolean flag = StringPlusPreCompile.compareStringPlus(string1, string2);
		System.out.println(flag);
	}
}
