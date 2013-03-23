package com.github.zxddxp.LC;

public class Jump {

	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null || A.length == 0) {
			return 0;
		}

		int currentMax = 0;
		int currentStep = 0;
		int i = 0;
		while (currentMax < (A.length-1)) {
			currentStep++;
			int localMax = currentMax;
			while (i <= currentMax) {
				if ((A[i]+i) > localMax) {
					localMax = A[i]+i;
				}
				i++;
			}
			currentMax = localMax;
		}

		return currentStep;
	}

}
