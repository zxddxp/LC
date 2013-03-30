    package com.github.zxddxp.LC;

    import java.util.LinkedList;

    public class MaximalRectangle {
        public int maximalRectangle(char[][] matrix) {
            // Start typing your Java solution below
            // DO NOT write main() function

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            int[][] count = new int[m][n];
            int maxCount = 0;

            //fill in the "single-column bar"
            for (int j = 0; j < n; j++) {
               int bar = 0;
               for (int i = 0; i < m; i++) {
                   if (matrix[i][j] == '1') {
                       bar++;
                   }
                   else {
                       bar = 0;
                   }
                   count[i][j] = bar;
               }
            }

            //now do the count
            for (int i = 0; i < m; i++) {
                LinkedList<Integer> idx = new LinkedList<Integer>();
                LinkedList<Integer> val = new LinkedList<Integer>();
                val.addLast(0); //sentinel
                for (int j = 0; j < n; j++) {
                    int lastJ = j;
                    while (val.peekLast() > count[i][j]) {
                        int k = val.pollLast();
                        int d = idx.pollLast();
                        lastJ = d;
                        if (k*(j-d) > maxCount) {
                            maxCount = k*(j-d);
                        }
                    }
                    if (val.peekLast() != count[i][j]) {
                        idx.addLast(lastJ);
                        val.addLast(count[i][j]);
                    }
                }
                int k;
                while ((k = val.pollLast()) != 0) {
                    int d = idx.pollLast();
                    if (k*(n-d) > maxCount) {
                        maxCount = k*(n-d);
                    }
                }
            }

            return maxCount;
        }

        public static void main (String[] args) {
            MaximalRectangle m = new MaximalRectangle();
            char[][] c = new char[1][1];
            c[0][0] = '1';
            System.out.println(m.maximalRectangle(c));
        }
    }
