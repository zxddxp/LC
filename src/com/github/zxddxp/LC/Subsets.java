package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == null || S.length == 0) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
			result.add(new ArrayList<Integer>());
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(2^S.length);	
		result.add(new ArrayList<Integer>());

		ArrayList<Integer> SS = new ArrayList<Integer>(S.length);
		for (int i = 0; i < S.length; i++) {
			SS.add(S[i]);
		}
		Collections.sort(SS);

		for (int i = 0; i < SS.size(); i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> a = result.get(j);
				ArrayList<Integer> b = new ArrayList<Integer>();
				for (Integer k : a) {
					b.add(k);
				}
				b.add(SS.get(i));
				result.add(b);
			}
		}

		return result;
	}

}
