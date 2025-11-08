package com.k1ts.app.personal.sorting;

import java.util.Arrays;

public class SortingAlgorithmBubble implements SortingAlgorithm {

    @Override
    public int[] sort(int[] unsortedArray) {
        int[] result = Arrays.copyOf(unsortedArray, unsortedArray.length);

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    int tmp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = tmp;
                }
            }
        }

        return result;
    }
}
