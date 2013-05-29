package com.github.zxddxp.LC;

public class Trap {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;

        if (A == null || A.length <= 1) {
            return 0;
        }

        int leftIdx = 0;
        int leftHeight = A[0];
        int acc = 0;
        //forward pass
        for (int i = 1; i < A.length; i++) {
            if (A[i] < leftHeight) {
                acc += leftHeight - A[i];
            } else {
                result += acc;
                leftIdx = i;
                leftHeight = A[i];
                acc = 0;
            }
        }
        //backward pass
        acc = 0;
        leftHeight = A[A.length - 1];
        int max = leftIdx;
        for (int j = A.length - 2; j >= max; j--) {
            if (A[j] < leftHeight) {
                acc += leftHeight - A[j];
            } else {
                result += acc;
                leftIdx = j;
                leftHeight = A[j];
                acc = 0;
            }
        }

        return result;
    }

}
