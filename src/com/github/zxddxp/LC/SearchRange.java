package com.github.zxddxp.LC;

public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int[] result = {-1, -1};
        if (A == null || A.length == 0) {
            return result;
        }
        int left = 0;
        int right = A.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (A[mid] == target) {
                break;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }

        //if didn't find target
        if (left > right) {
            return result;
        }

        int loc = mid;
        left = 0;
        right = loc - 1;
        mid = (left + right) / 2;
        while (left <= right) {
            if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        result[0] = right + 1;

        left = loc + 1;
        right = A.length - 1;
        mid = (left + right) / 2;
        while (left <= right) {
            if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        result[1] = left - 1;

        return result;
    }

}
