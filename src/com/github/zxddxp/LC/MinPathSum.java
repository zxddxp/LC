package com.github.zxddxp.LC;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int k = grid[i][j];
                grid[i][j] = k + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

}
