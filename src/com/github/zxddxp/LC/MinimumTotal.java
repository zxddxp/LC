package com.github.zxddxp.LC;

import java.util.ArrayList;

public class MinimumTotal {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if( triangle == null || triangle.get(0) == null) {
			return 0;
		}

		int n = triangle.size();
		int[] last = new int[n];
		int[] current = new int[n];
		last[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			current[0] = last[0] + triangle.get(i).get(0);
			current[i] = last[i-1] + triangle.get(i).get(i);
			for (int j = 1; j < i; j++) {
				current[j] = triangle.get(i).get(j) + Math.min(last[j-1], last[j]);
			}
			int[] temp;
			temp = last;
			last = current;
			current = temp;
		}
		int m = last[0];
		for (int j = 1; j < n; j++) {
			if (last[j] < m) {
				m = last[j];
			}
		}
		return m;
	}

}
