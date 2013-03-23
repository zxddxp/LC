package com.github.zxddxp.LC;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (digits == null || digits.length == 0) {
			int[] result = {}; 
			return result;
		}

		boolean allNine = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				allNine = false;
				break;
			}
		}
		if (allNine) {
			int[] result = new int[digits.length+1];
			result[0] = 1;
			return result;
		}
		else {
			int[] result = new int[digits.length];
			int carry = 1;
			for (int i = digits.length-1; i >= 0; i--) {
				int temp = digits[i] + carry;
				carry = temp / 10;
				result[i] = temp % 10;
			}
			return result;
		}
	}

}
