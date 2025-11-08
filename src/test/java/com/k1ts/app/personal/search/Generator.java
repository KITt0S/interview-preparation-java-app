package com.k1ts.app.personal.search;

import java.util.Random;

public class Generator {

    Data generateRandomInitialData() {
        Random random = new Random();

        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100);
        }

        int index = random.nextInt(10);

        return new Data(index, result[index], result);
    }

    Data generateDefaultData() {
        return new Data(3, 2, new int[] {5, 4, 3, 2, 1});
    }

    static class Data {
        private final int index;
        private final int value;
        private final int[] array;

        Data(int index, int value, int[] array) {
            this.index = index;
            this.value = value;
            this.array = array;
        }

        int getIndex() {
            return index;
        }

        int getValue() {
            return value;
        }

        int[] getArray() {
            return array;
        }
    }
}
