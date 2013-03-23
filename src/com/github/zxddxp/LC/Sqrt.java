package com.github.zxddxp.LC;

public class Sqrt {
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (x == 0 || x == 1) {
			return x;
		}

		int right = x;
		int left = 1;

		while (left <= right) {
			int mid = (left+right)/2;
			int guess = x/mid;
			if (guess == mid) {
				return mid;
			}
			else if ( guess > mid) {
				left = mid+1;
			}
			else {
				right = mid - 1;
			}
		}

		return left-1;
	}

}
