package com.github.zxddxp.LC;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 || n == 0) {
            return 0;
        } else {
            int[][] matrix = new int[m][n];
            if (obstacleGrid[0][0] == 0) {
                matrix[0][0] = 1;
            } else {
                matrix[0][0] = 0;
            }

            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] == 0) {
                    matrix[i][0] = matrix[i - 1][0];
                } else {
                    matrix[i][0] = 0;
                }
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[0][j] == 0) {
                    matrix[0][j] = matrix[0][j - 1];
                } else {
                    matrix[0][j] = 0;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }

            return matrix[m - 1][n - 1];
        }
    }
}
