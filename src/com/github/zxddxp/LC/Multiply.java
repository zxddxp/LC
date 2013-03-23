package com.github.zxddxp.LC;

public class Multiply {

	public String multiply(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function

		String result = null;
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		boolean pos = true;
		if (num1.charAt(0) == '-') {
			pos = !pos;
			num1 = num1.substring(1, num1.length());
		}
		if (num2.charAt(0) == '-') {
			pos = !pos;
			num2 = num2.substring(1, num2.length());
		}
		for (int i = 0; i < num2.length(); i++) {
			String s = multiply(num1, num2.charAt(i));
			if (result == null) {
				result = s;
			}
			else {
				result = result + "0";
				result = add(result, s);
			}
		}

		if (pos) {
			return result;
		}
		else {
			return "-"+result;
		}
	}

	public String multiply(String num, char c) {
		if (c == '0') {
			return "0";
		}
		else if (c == '1') {
			return num;
		}
		else {
			char[]	digits = {'0','1','2','3','4','5','6','7','8','9'};
			int cc = (int) (c - '0');
			StringBuffer sb = new StringBuffer();
			int carry = 0;
			for (int i = num.length()-1; i >= 0; i--) {
				carry += ((int) (num.charAt(i)-'0'))*cc;
				sb.append(digits[carry % 10]);
				carry = carry / 10;
			}
			if (carry != 0) {
				sb.append(digits[carry]);
			}
			return sb.reverse().toString();
		}
	}

	public String add(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[]	digits = {'0','1','2','3','4','5','6','7','8','9'};
		if (num1 == null || num1.length() == 0) {
			return num2;
		}
		if (num2 == null || num2.length() == 0) {
			return num1;
		}

		int carry = 0;
		StringBuffer sb = new StringBuffer();
		int end1 = num1.length()-1;
		int end2 = num2.length()-1;
		while (end1 >= 0 || end2 >= 0) {
			if (end1 >= 0) {
				carry += (int) (num1.charAt(end1) - '0');
			}
			if (end2 >= 0) {
				carry += (int) (num2.charAt(end2) - '0');
			}
			sb.append(digits[carry % 10]);
			carry = carry/10;
			end1--;
			end2--;
		}
		if (carry != 0) {
			sb.append(digits[carry]);
		}
		return sb.reverse().toString();
	}

}
