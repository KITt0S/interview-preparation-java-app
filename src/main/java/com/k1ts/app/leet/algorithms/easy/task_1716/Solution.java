package com.k1ts.app.leet.algorithms.easy.task_1716;

public class Solution {

    public int totalMoney(int n) {
        int money = 0;
        int coefficient = 1;

        if (n <= 0) {
            return money;
        }

        int daysCountPerWeek = 7;
        int weekCount = (n - 1) / daysCountPerWeek + 1;
        int lastDaysCount = (n - 1) % daysCountPerWeek + 1;

        int moneyOnFirstDay = 1;
        int moneyOnLastDay = moneyOnFirstDay + (lastDaysCount - 1) * coefficient;
        int moneyPerFirstWeekLastDaysCount = (moneyOnFirstDay + moneyOnLastDay) * lastDaysCount / 2;

        if (weekCount == 1) {
            return moneyPerFirstWeekLastDaysCount;
        }

        int moneyTotalWeekBase = 28;

        int moneyTotalWeekBaseCollected = (weekCount - 1) * moneyTotalWeekBase;

        int moneyAfterFirstWeekLastDaysIncreased = (weekCount - 1) * lastDaysCount;

        if (weekCount == 2) {
            return moneyTotalWeekBaseCollected + moneyAfterFirstWeekLastDaysIncreased + moneyPerFirstWeekLastDaysCount;
        }

        int moneyTotalWeekBaseIncreased = 7;

        int moneyTotalWeekBaseIncreasedCollected = (moneyTotalWeekBaseIncreased
                + moneyTotalWeekBaseIncreased
                + (weekCount - 3) * moneyTotalWeekBaseIncreased) * (weekCount - 2) / 2;

        return moneyTotalWeekBaseCollected
                + moneyTotalWeekBaseIncreasedCollected
                + moneyAfterFirstWeekLastDaysIncreased
                + moneyPerFirstWeekLastDaysCount;
    }
}
