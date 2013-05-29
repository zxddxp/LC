package com.github.zxddxp.LC;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board == null || board[0] == null) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int k = (int) (board[i][j] - '0');
                    if (flags[k]) {
                        return false;
                    } else {
                        flags[k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else {
                    int k = (int) (board[j][i] - '0');
                    if (flags[k]) {
                        return false;
                    } else {
                        flags[k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int row = (i / 3) * 3 + j / 3;
                int col = (i % 3) * 3 + j % 3;
                if (board[row][col] == '.') {
                    continue;
                } else {
                    int k = (int) (board[row][col] - '0');
                    if (flags[k]) {
                        return false;
                    } else {
                        flags[k] = true;
                    }
                }
            }
        }

        return true;
    }

}
