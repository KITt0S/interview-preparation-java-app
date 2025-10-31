package com.k1ts.app.personal.sorting;

import java.util.Arrays;

public class Solution {

    public int[] sortingByShiftingAndInsertingSmallestToStart(int[] unsortedArray) {
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

    public int[] sortingBubble(int[] unsortedArray) {
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

    public int[] sortingBySwappingCurrentWithMinimum(int[] unsortedArray) {
        int[] result = Arrays.copyOf(unsortedArray, unsortedArray.length);

        for (int i = 0; i < result.length - 1; i++) {
            int index = i;
            int minValue = result[i];
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < minValue) {
                    index = j;
                    minValue = result[j];
                }
            }

            if (index != i) {
                int tmp = result[i];
                result[i] = minValue;
                result[index] = tmp;
            }
        }

        return result;
    }
}
