package com.github.zxddxp.LC;

public class NumDistinct {

	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (S.length() == 0 || T.length() == 0) {
			return 0;
		}

		int[] acc1 = new int[S.length()];
		char c = T.charAt(T.length()-1);
		int countSoFar = 0;
		for (int i = S.length()-1; i >= 0; i--) {
			if (S.charAt(i) == c) {
				countSoFar++;
			}
			acc1[i] = countSoFar;
		}

		for (int j = T.length()-2; j >= 0; j--) {
			c = T.charAt(j);
			countSoFar = 0;
			int[] acc2 = new int[S.length()];
			for (int i = S.length()-T.length() + j; i >= 0; i--) {
				if (S.charAt(i) == c) {
					countSoFar += acc1[i+1];
				}
				acc2[i] = countSoFar;
			}
			acc1 = acc2;
		}

		return acc1[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumDistinct s = new NumDistinct();
		System.out.println(s.numDistinct("rabbbit", "rabit"));
	}

}
