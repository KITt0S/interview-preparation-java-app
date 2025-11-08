package com.k1ts.app.personal.sorting;

import java.util.Arrays;

public class SortingAlgorithmBySwappingCurrentWithMinimum implements SortingAlgorithm {

    @Override
    public int[] sort(int[] unsortedArray) {
        int[] result = Arrays.copyOf(unsortedArray, unsortedArray.length);

        for (int i = 0; i < result.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[index]) {
                    index = j;
                }
            }

            if (index != i) {
                int tmp = result[i];
                result[i] = result[index];
                result[index] = tmp;
            }
        }

        return result;
    }
}
