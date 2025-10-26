package com.k1ts.app.leet.algorithms.easy.task_1;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void twoSum() {
        Solution solution = new Solution();
        Assert.assertEquals(new int[]{0, 1}, solution.twoSum(new int[]{2,7,11,15}, 9));
        Assert.assertEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6));
    }
}