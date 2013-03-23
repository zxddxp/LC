package com.github.zxddxp.LC;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (matrix == null || matrix.length == 0 || matrix[0][0] > target) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int left = 0;
		int right = m-1;
		while ( left <= right ) {
			int mid = (left+right)/2;
			if (matrix[mid][0] == target) {
				return true;
			}
			else if (matrix[mid][0] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		int k = left-1;
		left = 0;
		right = n-1;
		while ( left <= right ) {
			int mid = (left+right)/2;
			if (matrix[k][mid] == target) {
				return true;
			}
			else if (matrix[k][mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return false;

	}

}
