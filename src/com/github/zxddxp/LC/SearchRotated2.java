package com.github.zxddxp.LC;

public class SearchRotated2 {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //cheating!
        //for [1,1,1,1,2,1,1,1] -- you never know where the 2 is without scan
        if (A == null || A.length == 0 || (A.length == 1 && A[0] != target)) {
            return false;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }

}
