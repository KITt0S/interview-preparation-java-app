package com.k1ts.app.personal.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SolutionTest {

    @Test
    public void sortingByPaddingSmallestToStart() {
        Solution solution = new Solution();

        int[] array = generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingByPaddingAndInsertingSmallestToStart(array);

        String message = "Sorting failed:\n" +
                "initial array: " + Arrays.toString(array) + "\n"
                + "expected array: " + Arrays.toString(expected) + "\n"
                + "actual array: " + Arrays.toString(actual) + "\n";

        Assert.assertArrayEquals(message, expected, actual);
    }

    @Test
    public void sortingBubble() {
    }

    private int[] generateRandomArray() {
        Random random = new Random();

        int[] result = new int[101];

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100);
        }

        return result;
    }

    private int[] getSortedArray(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }

    public static void main(String[] args) {
        SolutionTest test = new SolutionTest();

        int[] initialArray = test.generateRandomArray();

        System.out.println(Arrays.toString(initialArray));
        System.out.println(Arrays.toString(test.getSortedArray(initialArray)));
    }
}