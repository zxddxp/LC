package com.github.zxddxp.LC;

public class SortColors {
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null || A.length == 0 || A.length == 1) {
			return;
		}

		int last0 = -1;
		int first2 = A.length;
		int left1 = -1;
		int front = 0;
		while (front < first2) {
			switch (A[front]) {
			case 0:
				last0++;
				A[last0] = 0;
				if (left1 != -1) {//at least one "1" has seen before
					left1++;
					A[front] = 1;
				}
				front++;
				break;
			case 1:
				if (left1 == -1) {
					left1 = front;
				}
				front++;
				break;
			case 2:
				A[front] = A[first2-1];
				first2--;
				A[first2] = 2;
				break;
			default:

			}
		}
	}

}
