package com.github.zxddxp.LC;

public class Merge {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int end = m + n -1;
		m--;
		n--;
		while ( m >= 0 && n >= 0 ) {
			if (A[m] >= B[n]) {
				A[end] = A[m];
				m--;
			}
			else {
				A[end] = B[n];
				n--;
			}
			end--;
		}
		if ( m < 0 ) {
			while ( n >= 0 ) {
				A[n] = B[n];
				n--;
			}
		}
	}

}
