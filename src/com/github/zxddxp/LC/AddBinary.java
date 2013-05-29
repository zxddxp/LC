package com.github.zxddxp.LC;

public class AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int aI = 0;
            int bI = 0;
            if (i >= 0) {
                aI = Integer.parseInt(a.substring(i, i + 1));
                i--;
            }
            if (j >= 0) {
                bI = Integer.parseInt(b.substring(j, j + 1));
                j--;
            }
            int count = aI + bI + carry;
            switch (count) {
                case 0:
                    result.insert(0, '0');
                    carry = 0;
                    break;
                case 1:
                    result.insert(0, '1');
                    carry = 0;
                    break;
                case 2:
                    result.insert(0, '0');
                    carry = 1;
                    break;
                case 3:
                    result.insert(0, '1');
                    carry = 1;
                    break;
            }
        }
        if (carry > 0) {
            result.insert(0, '1');
        }

        return result.toString();
    }

}
