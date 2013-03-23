package com.github.zxddxp.LC;

public class CanJump {

	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int currentMax = -1;
		if (A == null || A.length == 0) {
			return true;
		}
		for (int i = 0; i < A.length-1; i++) {
			if (A[i] != 0) {
				if ( (i+A[i]) > currentMax) {
					currentMax = i+A[i];
				}
			}
			else {
				if (currentMax <= i) {
					return false;
				}
			}
		}

		return true;

	}

}
