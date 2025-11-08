package com.k1ts.app.personal.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    private final Generator generator = new Generator();

    @Test
    public void sortingByShiftingAndInsertingSmallestToStart() {
        Solution solution = new Solution();

        int[] array = generator.generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingByShiftingAndInsertingSmallestToStart(array);

        Assert.assertArrayEquals(getMessage(array, expected, actual), expected, actual);
    }

    @Test
    public void sortingBubble() {
        Solution solution = new Solution();

        int[] array = generator.generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingBubble(array);

        String message = getMessage(array, expected, actual);

        Assert.assertArrayEquals(message, expected, actual);
    }

    @Test
    public void sortingBySwappingCurrentWithMinimum() {
        Solution solution = new Solution();

        int[] array = generator.generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = solution.sortingBySwappingCurrentWithMinimum(array);

        Assert.assertArrayEquals(getMessage(array, expected, actual), expected, actual);
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
}