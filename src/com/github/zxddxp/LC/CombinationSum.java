package com.github.zxddxp.LC;

import java.util.*;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int size = candidates.length;

		Arrays.sort(candidates);

		String[][] hist = new String[size][target+1];

		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < size; j++) {
				StringBuilder sb = new StringBuilder();
				if (candidates[j] == i) {
					sb.append(Integer.toString(i) + ",");
				}
				else {
					int delta = candidates[j];
					if ((i-delta) > 0) {
						for (int k = 0; k <= j; k++) {
							if (hist[k][i-delta] != null) {
								String[] old = hist[k][i-delta].split(",");
								for (String s : old) {
									sb.append(s + " " + Integer.toString(candidates[j]));
									sb.append(",");
								}
							}
						}
					}
				}
				if (sb.length() > 0) {
					hist[j][i] = sb.substring(0, sb.length()-1);
					//System.out.println(candidates[j] + " " + i + ": " + hist[j][i]);
				}
			}
		}

		for (int j = 0; j < size; j++) {
			if (hist[j][target] != null) {
				String[] ss = hist[j][target].split(",");
				for (String s : ss) {
					String[] cc = s.trim().split("\\s+");
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (String c : cc) {
						temp.add(Integer.parseInt(c));
					}
					result.add(temp);
				}
			}
		}

		return result;
	}
}
