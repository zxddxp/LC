package com.github.zxddxp.LC;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null || A.length == 0) {
			return 0;
		}

		int end = A.length;
		int i = 0;
		while ( i < end ) {
			if (A[i] == elem) {
				A[i] = A[end -1];
				end --;
			}
			else {
				i++;
			}
		}

		return end;

	}

}
