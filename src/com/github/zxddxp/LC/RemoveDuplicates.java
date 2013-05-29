package com.github.zxddxp.LC;

public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A.length <= 1) {
            return A.length;
        }
        int tail = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[tail - 1]) {
                A[tail] = A[i];
                tail++;
            }
        }
        return tail;
    }

}
