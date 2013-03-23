package com.github.zxddxp.LC;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (num == null || num.length <= 1) {
			return;
		}

		int i = num.length - 1;
		while (i > 0) {
			if (num[i] > num[i-1]) {
				break;
			}
			i--;
		}
		reverse(num, i, num.length-1);

		if (i > 0) {
			int j = i;
			while( j < num.length ) {
				if (num[j] > num[i-1]) {
					break;
				}
				j++;
			}
			int temp = num[i-1];
			num[i-1] = num[j];
			num[j] = temp;

		}
	}

	public void reverse (int[] num, int start, int end) {
		while (start < end) {
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;
			start++;
			end--;
		}
	}

}
