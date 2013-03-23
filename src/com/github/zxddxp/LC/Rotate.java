package com.github.zxddxp.LC;

public class Rotate {
	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (matrix == null || matrix.length == 0) {
			return;
		}

		int n = matrix.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < (n-1)-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}

	}

}
