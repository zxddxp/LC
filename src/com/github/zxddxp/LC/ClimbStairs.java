package com.github.zxddxp.LC;

public class ClimbStairs {
	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int his1, his2;
		his1 = 1;
		his2 = 2;

		n = n-2;
		int result = 0;
		while (n > 0) {
			result = his1 + his2;
			his1 = his2;
			his2 = result;
			n--;
		}

		return result;

	}

}