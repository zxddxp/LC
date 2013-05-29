package com.github.zxddxp.LC;

import java.util.*;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (num == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //step 1, sort the array
        Arrays.sort(num);

        //step 2, build a dictionary
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            Integer I = new Integer(num[i]);
            if (dict.containsKey(I)) {
                dict.put(I, dict.get(I) + 1);
            } else {
                dict.put(I, 1);
            }
        }

        //treat (0,0,0) specially
        if (dict.containsKey(0)) {
            if (dict.get(0) > 2) {
                ArrayList<Integer> triple = new ArrayList<Integer>(3);
                triple.add(0);
                triple.add(0);
                triple.add(0);
                result.add(triple);
            }
        }

        //step 2, traverse
        int i = 0;
        while (i < num.length - 2 && num[i] < 0) {
            int j = i + 1;
            while (j < num.length - 1) {
                int needed = 0 - num[i] - num[j];

                if (needed < num[j]) {
                    break;
                }

                if (needed > num[j] && dict.containsKey(needed)) {//look beyond j
                    ArrayList<Integer> triple = new ArrayList<Integer>(3);
                    triple.add(num[i]);
                    triple.add(num[j]);
                    triple.add(needed);
                    result.add(triple);
                } else if (needed == num[j] && dict.get(needed) > 1) {
                    ArrayList<Integer> triple = new ArrayList<Integer>(3);
                    triple.add(num[i]);
                    triple.add(num[j]);
                    triple.add(num[j]);
                    result.add(triple);
                }

                //now move j forward
                j++;
                while ((j < num.length - 1) && num[j] == num[j - 1]) {
                    j++;
                }
            }

            //now move i forward
            i++;
            while ((i < num.length - 2) && num[i] == num[i - 1]) {
                i++;
            }
        }
        return result;
    }
}
