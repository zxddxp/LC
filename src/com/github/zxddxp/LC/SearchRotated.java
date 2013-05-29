package com.github.zxddxp.LC;

public class SearchRotated {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A == null || A.length == 0 || (A.length == 1 && A[0] != target)) {
            return -1;
        }
        int n = A.length;

        if (A[0] == target) {
            return 0;
        } else if (A[n - 1] == target) {
            return n - 1;
        } else if (A[0] < A[n - 1]) {//corner case of single segment
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (A[mid] == target) {
                    return mid;
                } else if (A[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        } else if (A[0] < target) {//on the left segment
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (A[mid] == target) {
                    return mid;
                } else if ((A[mid] <= A[n - 1]) || (A[mid] > target)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        } else if (A[n - 1] < target) {
            return -1;
        } else {//on the right segment
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (A[mid] == target) {
                    return mid;
                } else if ((A[mid] >= A[0]) || (A[mid] < target)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

}
