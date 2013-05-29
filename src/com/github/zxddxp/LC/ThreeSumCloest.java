package com.github.zxddxp.LC;

import java.util.Arrays;

public class ThreeSumCloest {

    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int result = Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;

        //step 1, sort the array
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;

            while (end > start) {
                while (end > (start + 1)) {
                    //step 2, move end
                    if (num[i] + num[start] + num[end] > target
                            && num[i] + num[start] + num[end - 1] > target) {
                        end--;
                    } else {
                        break;
                    }
                }
                int tempResult = Math.abs(num[i] + num[start] + num[end] - target);
                if (tempResult < result) {
                    result = tempResult;
                    sum = num[i] + num[start] + num[end];
                }
                if (end > (start + 1)) {
                    tempResult = Math.abs(num[i] + num[start] + num[end - 1] - target);
                    if (tempResult < result) {
                        result = tempResult;
                        sum = num[i] + num[start] + num[end - 1];
                    }
                }
                start++;
            }
        }

        return sum;

    }
}