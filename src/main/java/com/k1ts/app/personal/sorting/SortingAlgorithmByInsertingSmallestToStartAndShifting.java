package com.k1ts.app.personal.sorting;

import java.util.Arrays;

public class SortingAlgorithmByInsertingSmallestToStartAndShifting implements SortingAlgorithm {

    @Override
    public int[] sort(int[] unsortedArray) {
        int[] result = Arrays.copyOf(unsortedArray, unsortedArray.length);

        for (int i = 0; i < result.length - 1; i++) {
            int tmpMinValue = result[i];
            int indexOfTmpMinValue = i;
            for (int j = i; j < result.length; j++) {
                if (result[j] < tmpMinValue) {
                    tmpMinValue = result[j];
                    indexOfTmpMinValue = j;
                }
            }

            int tmp = tmpMinValue;
            int[] copy = Arrays.copyOfRange(result, i, indexOfTmpMinValue);

            for (int j = 0; j < copy.length; j++) {
                result[i + 1 + j] = copy[j];
            }

            result[i] = tmp;
        }

        return result;
    }
}
