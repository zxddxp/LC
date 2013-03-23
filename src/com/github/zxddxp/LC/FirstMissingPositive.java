package com.github.zxddxp.LC;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0) {
			return 1;
		}

		int result = A.length+1;

		for (int i = 0; i < A.length; i++) {
			int k = A[i];
			A[i] = 0;
			if (k <= 0 || k > A.length) {
				continue;
			}
			else {
				while (true) {
					int j = A[k-1];
					A[k-1] = k;
					if (j <= 0 || j > A.length || A[j-1] == j) {
						break;
					}
					k = j;
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i+1) {
				result = i+1;
				break;
			}
		}

		return result;
	}

}
