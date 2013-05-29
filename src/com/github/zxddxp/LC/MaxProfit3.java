package com.github.zxddxp.LC;

public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (prices.length == 0) {
            return 0;
        }

        int[] forward = new int[prices.length];
        int[] backward = new int[prices.length];

        int minSoFar = prices[0];
        forward[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            forward[i] = forward[i - 1];
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            } else if (prices[i] - minSoFar > forward[i - 1]) {
                forward[i] = prices[i] - minSoFar;
            }
        }

        int maxSoFar = prices[prices.length - 1];
        backward[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            backward[i] = backward[i + 1];
            if (prices[i] > maxSoFar) {
                maxSoFar = prices[i];
            } else if (maxSoFar - prices[i] > backward[i + 1]) {
                backward[i] = maxSoFar - prices[i];
            }
        }

        int sum = Math.max(forward[prices.length - 1], backward[0]);
        for (int i = 0; i < prices.length - 1; i++) {
            if ((forward[i] + backward[i + 1]) > sum) {
                sum = forward[i] + backward[i + 1];
            }
        }

        return sum;
    }
}
