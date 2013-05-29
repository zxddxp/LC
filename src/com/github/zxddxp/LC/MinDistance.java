package com.github.zxddxp.LC;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int m = word1.length();
        int n = word2.length();
        int[][] score = new int[m][n];

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        //fill in the corner
        if (w1[0] == w2[0]) {
            score[0][0] = 0;
        } else {
            score[0][0] = 1;
        }

        //fill in the 1st row
        for (int j = 1; j < n; j++) {
            if (w1[0] == w2[j]) {
                score[0][j] = j;
            } else {
                score[0][j] = score[0][j - 1] + 1;
            }
        }

        //fill in the 1st column
        for (int i = 1; i < m; i++) {
            if (w1[i] == w2[0]) {
                score[i][0] = i;
            } else {
                score[i][0] = score[i - 1][0] + 1;
            }
        }

        //now, fill in the rest of the score matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int tempScore = score[i - 1][j - 1];
                if (w1[i] != w2[j]) {
                    tempScore++;
                }
                tempScore = Math.min(tempScore, score[i - 1][j] + 1);
                tempScore = Math.min(tempScore, score[i][j - 1] + 1);
                score[i][j] = tempScore;
            }
        }

        return score[m - 1][n - 1];
    }

}
