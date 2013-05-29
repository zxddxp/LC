package com.github.zxddxp.LC;

public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function

        boolean toBuy = true;
        int sum = 0;
        int i = 0;
        int price = 0;

        while (i < prices.length) {
            if (toBuy) {
                while (i < prices.length - 1) {
                    if (prices[i] < prices[i + 1]) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < prices.length - 1) {
                    price = prices[i];
                    toBuy = false;
                }

            } else {
                while (i < prices.length - 1) {
                    if (prices[i] > prices[i + 1]) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < prices.length) {
                    sum = sum + prices[i] - price;
                    toBuy = true;
                }
            }

            i++;
        }

        return sum;

    }
}
