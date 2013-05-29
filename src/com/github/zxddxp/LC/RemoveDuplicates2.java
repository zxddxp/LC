package com.github.zxddxp.LC;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A.length <= 2) {
            return A.length;
        }
        int tail = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[tail - 1] || A[i] != A[tail - 2]) {
                A[tail] = A[i];
                tail++;
            }
        }
        return tail;

    }

}
