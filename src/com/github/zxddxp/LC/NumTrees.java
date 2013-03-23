package com.github.zxddxp.LC;

public class NumTrees {
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n <= 1) {
			return 1;
		}
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int left = 0; left < i; left++) {
				count[i] += count[left]*count[i-left-1];
			}
		}
		return count[n];
	}

}
