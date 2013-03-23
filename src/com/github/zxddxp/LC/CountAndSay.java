package com.github.zxddxp.LC;

public class CountAndSay {

	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n == 0) {
			return new String("");
		}

		String result = new String("1");
		if (n == 1) {
			return result;
		}
		else {
			while (n > 1) {
				result = read(result);
				n--;
			}
			return result;
		}
	}

	public String read(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		int i = 1;
		char c = s.charAt(0);
		while (i < s.length()) {
			if (s.charAt(i) == c) {
				count++;
				i++;
			}
			else {
				sb.append(Integer.toString(count) + c);
				c = s.charAt(i);
				count = 1;
				i++;
			}
		}
		sb.append(Integer.toString(count) + c);

		return sb.toString();
	}

}
