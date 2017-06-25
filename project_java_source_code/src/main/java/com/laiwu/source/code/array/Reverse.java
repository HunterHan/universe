package com.laiwu.source.code.array;

public class Reverse {

	/**
	 * 【用于数组元素的倒置翻转的算法】
	 * @author CogniBoy
	 * @param srcArray
	 * @return 被翻转的数组索引
	 */
	public static int[] arrayReverse(int[] srcArray) {
		for (int i = 0; i < (srcArray.length / 2); i++) {
			// 取出数组中第i个元素
			int temp = srcArray[i];
			// 将数组中的第srcArray.length - 1 - i个元素放到第i个元素的位置
			srcArray[i] = srcArray[srcArray.length - 1 - i];
			// 将第i个位置的元素放到第srcArray.length - 1 - i的位置
			srcArray[srcArray.length - 1 - i] = temp;
		}
		return srcArray;
	}
}
