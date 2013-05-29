package com.github.zxddxp.LC;

public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        if (A[0] > target) {
            return 0;
        }
        if (A[n - 1] < target) {
            return n;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
