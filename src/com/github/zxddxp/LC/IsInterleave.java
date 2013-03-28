package com.github.zxddxp.LC;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s1 == null && s2 == null) {
            return s3 == null;
        }
        else if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        }
        else if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }

        if (s1.length() > s2.length()) {//to make sure |s1|<=|s2|
            String tempS = s1;
            s1 = s2;
            s2 = tempS;
        }

        int n = s1.length();
        int m = s2.length();
        if (s3.length() != (m+n)) {
            return false;
        }

        boolean[][] matrix = new boolean[n+1][m+1];
        matrix[0][0] = true;
        //fill out the 0-th row first
        for (int i = 1; i <= m; i++) {
            matrix[0][i] = matrix[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        //fill out the 0-th column next
        for (int i = 1; i <= n; i++) {
            matrix[i][0] = matrix[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        //fill out the rest of the (half) matrix
        for (int k = 2; k <= s3.length(); k++) {
            int i = 1;
            if (k > m) {
                i = k - m;
            }
            while (i <= n) {
                int j = k - i; //i+j=k
                if (j < 1) {
                    break;
                }
                matrix[i][j] = (matrix[i-1][j] && s1.charAt(i-1) == s3.charAt(k-1))
                        || (matrix[i][j-1] && s2.charAt(j-1) == s3.charAt(k-1));
                i++;
            }
        }

        return matrix[n][m];
    }

    public static void main (String[] args) {
        IsInterleave i = new IsInterleave();
        System.out.println(i.isInterleave("aa","ab","abaa"));
    }

}
