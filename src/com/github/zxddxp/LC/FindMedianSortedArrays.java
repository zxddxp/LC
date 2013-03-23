package com.github.zxddxp.LC;

public class FindMedianSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function

		wrong!
		
		double result = 0.0;
		int m = A.length;
		int n = B.length;

		if ( ((m+n) % 2) == 1 ) {
			result = (double) findKth( (m+n)/2, A, B, 0, m-1, 0, n-1);
		}
		else {
			result = findKth((m+n)/2, A, B, 0, m-1, 0, n-1)/2.0 + findKth((m+n)/2-1, A, B, 0, m-1, 0, n-1)/2.0;
		}

		return result;
	}

	public int findKth(int k, int A[], int B[], int aStart, int aEnd, int bStart, int bEnd) {
		int aMid = (aStart + aEnd)/2;
		int bMid = (bStart + bEnd)/2;
		int total = (aEnd - aStart + 1) + (bEnd - bStart + 1);


		return 0;
	}

}
