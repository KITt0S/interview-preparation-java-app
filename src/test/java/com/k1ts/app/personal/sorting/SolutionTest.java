package com.k1ts.app.personal.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SolutionTest {

    @Test
    public void sortingByShiftingAndInsertingSmallestToStart() {
        Solution solution = new Solution();

        int[] array = generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingByShiftingAndInsertingSmallestToStart(array);

        Assert.assertArrayEquals(getMessage(array, expected, actual), expected, actual);
    }

    @Test
    public void sortingBySwappingCurrentWithMinimum() {
        Solution solution = new Solution();

        int[] array = generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingBySwappingCurrentWithMinimum(array);

        Assert.assertArrayEquals(getMessage(array, expected, actual), expected, actual);
    }

    @Test
    public void sortingBubble() {
        Solution solution = new Solution();

        int[] array = generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingBubble(array);

        String message = getMessage(array, expected, actual);

        Assert.assertArrayEquals(message, expected, actual);
    }

    private int[] generateDefaultArray() {
        return new int[] {5, 4, 3, 2, 1};
    }

    private int[] generateRandomArray() {
        Random random = new Random();

        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100);
        }

        return result;
    }

    private int[] getSortedArray(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }

    private String getMessage(int[] array, int[] expected, int[] actual) {
        return "Sorting failed:\n" +
                "initial array: " + Arrays.toString(array) + "\n"
                + "expected array: " + Arrays.toString(expected) + "\n"
                + "actual array: " + Arrays.toString(actual) + "\n";
    }

    public static void main(String[] args) {
        SolutionTest test = new SolutionTest();

        int[] initialArray = test.generateRandomArray();

        System.out.println(Arrays.toString(initialArray));
        System.out.println(Arrays.toString(test.getSortedArray(initialArray)));
    }
}