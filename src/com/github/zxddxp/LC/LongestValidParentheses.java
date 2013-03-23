package com.github.zxddxp.LC;

import java.util.Stack;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int result = 0;
		if (s == null || s.length() == 0) {
			return result;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int[] rightLoc = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			}
			else {
				if (stack.isEmpty()) {
					continue;
				}
				else {
					int j = stack.pop();
					rightLoc[j]	= i;
				}
			}
		}
		int k = 0;
		int count = 0;
		while ( k < s.length() ) {
			if (rightLoc[k] > 0) {
				count += (rightLoc[k]-k+1);
				result = Math.max(result, count);
				k = rightLoc[k] + 1;
			}
			else {
				k++;
				count = 0;
			}
		}

		return result;
	}

}
