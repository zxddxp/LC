package com.github.zxddxp.LC;

public class MaxProfit {

	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (prices.length == 0) {
			return 0;
		}

		int sum = 0;

		int minSoFar = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minSoFar) {
				minSoFar = prices[i];
			}
			else if (prices[i] - minSoFar > sum) {
				sum = prices[i] - minSoFar;
			}
		}

		return sum;
	}
}
