package com.github.zxddxp.LC;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        int[] A = {1};
        int[] B = {1};
        System.out.println(f.findMedianSortedArrays(A, B));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A == null || B == null || (A.length == 0 && B.length == 0)) {
            return 0.0;//hope this will not happen
        } else if (A.length == 0) {
            double result1 = B[(B.length - 1) / 2];
            if (B.length % 2 == 1) {//odd
                return result1;
            } else {
                return (result1 + B[B.length / 2]) / 2.0;
            }
        } else if (B.length == 0) {
            double result1 = A[(A.length - 1) / 2];
            if (A.length % 2 == 1) {//odd
                return result1;
            } else {
                return (result1 + A[A.length / 2]) / 2.0;
            }
        }

        int n = A.length;
        int m = B.length;

        boolean pair = ((n + m) % 2 == 0);
        return helper(A, 0, A.length - 1, B, 0, B.length - 1, (A.length + B.length + 1) / 2 - 1, pair);
    }

    public double helper(int A[], int a0, int a1, int B[], int b0, int b1, int rank, boolean pair) {
        if (a1 < a0 || b1 < b0) {//base case
            if (a1 < a0) {
                double result1 = B[b0 + rank];
                double result2 = result1;
                if (pair) {
                    result2 = Integer.MAX_VALUE;
                    if (b0 + rank + 1 < B.length) {
                        result2 = Math.min(result2, B[b0 + rank + 1]);
                    }
                    if (a0 < A.length && A[a0] >= result1) {
                        result2 = Math.min(result2, A[a0]);
                    }
                }
                return (result1 + result2) / 2.0;
            } else {
                double result1 = A[a0 + rank];
                double result2 = result1;
                if (pair) {
                    result2 = Integer.MAX_VALUE;
                    if (a0 + rank + 1 < A.length) {
                        result2 = Math.min(result2, A[a0 + rank + 1]);
                    }
                    if (b0 < B.length && B[b0] >= result1) {
                        result2 = Math.min(result2, B[b0]);
                    }
                }
                return (result1 + result2) / 2.0;
            }
        } else {//normal cases
            int am = (a0 + a1) / 2;
            int bm = (b0 + b1) / 2;
            int left = (am - a0 + bm - b0 + 1);
            if (rank + 1 <= left) {
                if (A[am] >= B[bm]) {
                    a1 = am - 1;
                } else {
                    b1 = bm - 1;
                }
            } else {
                if (A[am] >= B[bm]) {
                    rank -= (bm - b0 + 1);
                    b0 = bm + 1;
                } else {
                    rank -= (am - a0 + 1);
                    a0 = am + 1;
                }
            }
            return helper(A, a0, a1, B, b0, b1, rank, pair);
        }
    }
}
