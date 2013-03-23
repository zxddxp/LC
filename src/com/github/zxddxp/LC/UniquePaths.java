package com.github.zxddxp.LC;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (m == 0 || n == 0) {
			return 0;
		}
		else if (m == 1 || n == 1) {
			return 1;
		}
		else {
			int[][] matrix = new int[m][n];
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 1;
			}
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 1;
			}
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
			return matrix[m-1][n-1];
		}

	}

}