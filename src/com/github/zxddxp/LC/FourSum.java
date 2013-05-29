package com.github.zxddxp.LC;

import java.util.*;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num == null || num.length < 4) {
            return result;
        }

        //step 1, sort the array
        Arrays.sort(num);

        //step 2, build the dictionary
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            Integer I = new Integer(num[i]);
            if (dict.containsKey(I)) {
                dict.put(I, dict.get(I) + 1);
            } else {
                dict.put(I, 1);
            }
        }

        //step 3, traverse
        int i = 0;
        while (i < num.length - 3 && (target - num[i]) >= (num[i] * 3)) {
            int j = i + 1;
            while (j < num.length - 2 && (target - num[i] - num[j]) >= (num[j] * 2)) {
                int k = j + 1;
                while (k < num.length - 1) {
                    int needed = target - (num[i] + num[j] + num[k]);
                    if (needed < num[k]) {
                        break;
                    } else if (needed > num[k] && dict.containsKey(needed)) {
                        ArrayList<Integer> q = new ArrayList<Integer>(4);
                        q.add(num[i]);
                        q.add(num[j]);
                        q.add(num[k]);
                        q.add(needed);
                        result.add(q);
                    } else if (needed == num[k]) {
                        if ((num[i] == num[j] && num[j] == num[k] && dict.get(needed) > 3)
                                || (num[i] != num[j] && num[j] == num[k] && dict.get(needed) > 2)
                                || (num[j] != num[k] && dict.get(needed) > 1)) {
                            ArrayList<Integer> q = new ArrayList<Integer>(4);
                            q.add(num[i]);
                            q.add(num[j]);
                            q.add(num[k]);
                            q.add(needed);
                            result.add(q);
                        }
                    }

                    //now move k forward
                    k++;
                    while ((k < num.length - 1) && num[k] == num[k - 1]) {
                        k++;
                    }
                }

                //now move j forward
                j++;
                while ((j < num.length - 2) && num[j] == num[j - 1]) {
                    j++;
                }
            }

            //now move i forward
            i++;
            while ((i < num.length - 3) && num[i] == num[i - 1]) {
                i++;
            }
        }

        return result;
    }

}
