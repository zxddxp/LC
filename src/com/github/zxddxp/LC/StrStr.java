package com.github.zxddxp.LC;

import java.util.HashSet;

public class StrStr {
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return null;
		}

		if (needle.equals("")) {
			return haystack;
		}
		
		if (needle.length() == haystack.length()) {
			return needle.equals(haystack)? haystack : null;
		}
		
		if (needle.length() == 1) {
			char c = needle.charAt(0);
			for (int i = 0; i < haystack.length(); i++) {
				if (haystack.charAt(i) == c) {
					return haystack.substring(i);
				}
			}
			return null;
		}

		char[] hay = haystack.toCharArray();
		int n = hay.length;
		boolean[] skip = new boolean[n];

		char[] nee = needle.toCharArray();
		int m = nee.length;

		//prepare the dictionary
		boolean[][] dict = new boolean[m][m];
		boolean[] run = new boolean[m];
		for (int i = 0; i < m; i++) {
			int end = m-1-i;
			char c = nee[end];
			//find the "failure" pruning
			for (int j = 0; j < end; j++) {
				dict[i][end - j] = run[end - j] || (nee[j] == c); 
			}
			for (int j = end+1; j < m; j++) {
				dict[i][j] = run[j];
			}
			//node, dict[?][0] is always untouched

			//update the "success" pruning
			for (int j = 1; j < end; j++) {
				run[end - j] = run[end - j] || (nee[j] != c); 
			}
		}
		
		//scan the haystack
		int k = 0;
		while (k < (n-m+1)) {
			int j = 0;
			for (j = m-1; j >=0 && nee[j] == hay[k+j]; j--) {
			}
			if (j < 0) {//success!
				break;
			}
			else {
				for (int l = 1; l < m; l++) {
					skip[k+l] = skip[k+l] || dict[m-j-1][l];
				}
			}
			k++;
			while (skip[k] && k < (n-m+1)) {
				k++;
			}
		}

		if (k < (n-m+1)) {
			return haystack.substring(k);
		}
		else {
			return null;
		}
	}
	
	public static void main (String[] args) {
		StrStr s = new StrStr();
		System.out.println(s.strStr("babba", "bbb"));
	}
}
