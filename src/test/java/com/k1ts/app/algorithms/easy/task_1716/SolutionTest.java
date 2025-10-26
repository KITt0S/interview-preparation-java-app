package com.k1ts.app.algorithms.easy.task_1716;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void totalMoney() {
        Solution solution = new Solution();
        Assert.assertEquals(10, solution.totalMoney(4));
        Assert.assertEquals(37, solution.totalMoney(10));
        Assert.assertEquals(96, solution.totalMoney(20));
        Assert.assertEquals(135, solution.totalMoney(26));
    }
}