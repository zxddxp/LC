package com.github.zxddxp.LC;

public class IntToRoman {

	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String alphabet = "IVXLCDM";
		String result = "";
		int i = 0;
		while (num > 0) {
			StringBuilder sb = new StringBuilder();
			int r = num % 10;
			if (r == 0) {
				i += 2;
				num /= 10;
				continue;
			}
			else if (r <= 3) {
				while ( r-- > 0 ) {
					sb.append(alphabet.charAt(i));
				}
			}
			else if (r == 4) {
				sb.append(alphabet.charAt(i));
				sb.append(alphabet.charAt(i+1));
			}
			else if (r == 5) {
				sb.append(alphabet.charAt(i+1));
			}
			else if (r <= 8) {
				sb.append(alphabet.charAt(i+1));
				while ( r-- > 5) {
					sb.append(alphabet.charAt(i));
				}
			}
			else {
				//assert r == 9;
				sb.append(alphabet.charAt(i));
				sb.append(alphabet.charAt(i+2));
			}

			result = sb.toString() + result;
			i += 2;

			num /= 10;
		}

		return result;
	}

}
