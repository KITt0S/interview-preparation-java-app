package com.k1ts.app.personal.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SearchTest {

    private Generator generator = new Generator();

    @Test
    public void getIndexByBinarySearch() {
        int testCaseCount = 10;
        for (int i = 0; i < testCaseCount; i++) {
            Generator.Data initialData = generator.generateRandomInitialData();

            int actualIndex = new Search().getIndexByBinarySearch(initialData.getArray(), initialData.getValue());

            Assert.assertEquals(getMessage(initialData, actualIndex), initialData.getIndex(), actualIndex);
        }
    }

    private String getMessage(Generator.Data initialData, int actualIndex) {
        return """
                Search failed:
                initial array: {}
                value to search: {}
                expected index: {}
                actual index: {}
                """
                .replaceFirst("\\{}", Arrays.toString(initialData.getArray()))
                .replaceFirst("\\{}", Integer.toString(initialData.getValue()))
                .replaceFirst("\\{}", Integer.toString(initialData.getIndex()))
                .replaceFirst("\\{}", Integer.toString(actualIndex));
    }

    public static void main(String[] args) {
        System.out.println(new SearchTest().getMessage(new Generator.Data(0, 1, new int[]{1, 1, 1}), 2));
    }
}