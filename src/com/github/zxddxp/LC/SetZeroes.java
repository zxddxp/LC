package com.github.zxddxp.LC;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) {
            return;
        }

        int i = m - 1;
        while (i >= 0) {
            boolean dirty = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dirty = true;
                    break;
                }
            }
            if (dirty) {
                break;
            } else {
                i--;
            }
        }

        if (i < 0) {//nothing to do
            return;
        } else {
            for (int k = 0; k < i; k++) {
                boolean dirty = false;
                for (int j = 0; j < n; j++) {
                    if (matrix[k][j] == 0) {
                        dirty = true;
                        matrix[i][j] = 0;
                    }
                }
                if (dirty) {
                    for (int j = 0; j < n; j++) {
                        matrix[k][j] = 0;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
