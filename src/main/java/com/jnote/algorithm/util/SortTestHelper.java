package com.jnote.algorithm.util;

import java.util.Random;

public class SortTestHelper {
    public static Integer[] generateRandomArray(int n, int low, int high) {

        Integer[] result = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt(high) + low;
        }
        return result;

    }
}
