package com.github.zxddxp.LC;

import java.util.ArrayList;

public class GenerateParenthesis {

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>(n+1);
		for (int i = 0; i <= n; i++) {
			matrix.add(new ArrayList<String>());
		}
		String s = "";
		matrix.get(0).add(s);
		s = "()";
		matrix.get(1).add(s);
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				for (String s1 : matrix.get(j)) {
					for (String s2: matrix.get(i-j-1)) {
						String ss = "("+s1+")"+s2;
						matrix.get(i).add(ss);
					}
				}
			}
		}

		return matrix.get(n);
	}

}
