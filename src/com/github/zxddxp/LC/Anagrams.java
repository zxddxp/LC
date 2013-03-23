package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length <= 1) {
			return result;
		}

		HashMap<String, Integer> dict = new HashMap<String,Integer>();
		for (String s : strs) {
			String ss = computeSig(s);
			if (dict.containsKey(ss)) {
				dict.put(ss, dict.get(ss)+1);
			}
			else {
				dict.put(ss, 1);
			}
		}

		for (String s : strs) {
			String ss = computeSig(s);
			if (dict.get(ss) > 1) {
				result.add(s);
			}
		}

		return result;
	}

	public String computeSig (String s) {
		if (s.equals("")) {
			return s;
		}
		else {
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			return new String(cs);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
