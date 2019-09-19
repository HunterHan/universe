package com.laiwu.algorithm.hundred;

import java.util.HashMap;
import java.util.Map;

public class Test {
    static final int s = 5; //自定义的台阶数

    static Map<Integer, Integer> map = new HashMap<>();

    static int compute(int stair) {
        if (stair <= 0) {
            return 0;
        }
        if (stair == 1) {
            return 1;
        }
        if (stair == 2) {
            return 2;
        }
        return compute(stair - 1) + compute(stair - 2);
    }

    public static void main(String args[]) {

        for (int i = 0; i < 20; i++) {
            int result = compute(i);
            map.put(i, result);
            System.out.println("" + result + "");

        }
    }
}