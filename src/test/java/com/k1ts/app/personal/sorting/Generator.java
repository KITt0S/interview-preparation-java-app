package com.k1ts.app.personal.sorting;

import java.util.Random;

public class Generator {

    int[] generateRandomArray() {
        Random random = new Random();

        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100);
        }

        return result;
    }

    int[] generateDefaultArray() {
        return new int[] {5, 4, 3, 2, 1};
    }
}
