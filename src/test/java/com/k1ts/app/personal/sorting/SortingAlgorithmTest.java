package com.k1ts.app.personal.sorting;

import com.k1ts.app.leet.algorithms.easy.task_1716.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public abstract class SortingAlgorithmTest {

    private final Generator generator = new Generator();

    private final SortingAlgorithm sortingAlgorithm;

    SortingAlgorithmTest(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Test
    public void sort() {
        int[] array = generator.generateRandomArray();

        int[] expected = getSortedArray(array);
        int[] actual = sortingAlgorithm.sort(array);

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
