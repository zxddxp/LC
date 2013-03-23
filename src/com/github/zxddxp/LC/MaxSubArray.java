package com.github.zxddxp.LC;

public class MaxSubArray {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null || A.length == 0) {
			return 0;
		}
		else {
			int acc = 0;
			int minSofar = 0;
			int maxSofar = Integer.MIN_VALUE;
			for (int i = 0; i < A.length; i++) {
				acc += A[i];
				if ((acc - minSofar) > maxSofar) {
					maxSofar = acc - minSofar;
				}
				if (acc < minSofar) {
					minSofar = acc;
				}
			}

			return maxSofar;
		}

	}

}
