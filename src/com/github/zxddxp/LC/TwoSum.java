package com.github.zxddxp.LC;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (numbers == null || numbers.length < 2) {
			return null;
		}
		else {
			int[] result = new int[2];
			if ((target % 2) == 0) {
				int first = 0;
				for (int i = 0; i < numbers.length; i++) {
					if (numbers[i] == (target/2)) {
						if (first == 0) {
							first = i+1;
						}
						else {
							result[0] = first;
							result[1] = i+1;
							return result;
						}
					}
				}
			}
			HashMap<Integer, Integer> dic = new HashMap<Integer,Integer>();
			for (int i = 0; i < numbers.length; i++) {
				dic.put(numbers[i], i+1);
			}
			for (Map.Entry<Integer, Integer> m : dic.entrySet()) {
				int a1 = m.getKey();
				if (dic.containsKey(target - a1)) {
					int idx1 = m.getValue();
					int idx2 = dic.get((int) (target-a1));
					result[0] = Math.min(idx1, idx2);
					result[1] = Math.max(idx1, idx2);
					return result;
				}
			}
			return null;
		}
	}

}
