package test.array;

import java.util.Arrays;

import org.junit.Test;

import com.laiwu.source.code.array.Reverse;

public class ArrayTest {

	/**
	 * 数组元素前后倒置翻转的算法测试
	 */
	@Test
	public void reverseTest() {
		int[] srcArray = { 1, 2, 3, 4, 5, 6 };
		System.out.println("原数组:\t\t" + Arrays.toString(srcArray));
		int[] dstArray = Reverse.arrayReverse(srcArray);
		System.out.println("reverse数组:\t" + Arrays.toString(dstArray));
	}
}
