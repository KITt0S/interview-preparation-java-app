package com.k1ts.app.personal.sorting;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import static org.junit.Assert.*;

public class SortingAlgorithmBySwappingCurrentWithMinimumTest extends SortingAlgorithmTest {

    public SortingAlgorithmBySwappingCurrentWithMinimumTest() {
        super(new SortingAlgorithmBySwappingCurrentWithMinimum());
    }
}