package com.github.zxddxp.LC;

import java.util.ArrayList;

public class LetterCombinations {
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			result.add(new String(""));
			return result;
		}
		String[] alpha = {" ", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		int[] bound = {1,0,3,3,3,3,3,4,3,4};
		int[] current = new int[digits.length()];
		int[] dd = new int[digits.length()];
		for (int i = 0; i < digits.length(); i++) {
			dd[i] = digits.charAt(i) - '0';
		}

		while (current[0] <= bound[dd[0]]) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digits.length(); i++) {
				if (dd[i] != 0) {
					sb.append(alpha[dd[i]].charAt(current[i]));
				}
			}
			result.add(sb.toString());
			int j = digits.length() - 1;
			while (j >= 0) {
				current[j] ++;
				if (current[j] >= bound[dd[j]]) {
					j--;
				}
				else {
					break;
				}
			}
			if ( j < 0 ) {
				break;
			}
			while ( ++j < digits.length() ) {
				current[j] = 0;
			}
		}

		return result;
	}

}
