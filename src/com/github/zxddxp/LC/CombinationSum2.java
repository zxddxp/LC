package com.github.zxddxp.LC;

import java.util.*;

public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //size is the number of num, also the # of rows in the DP matrix
        int size = num.length;

        //to make sure the results are (1) unique and (2) in sorted order, we sort the num
        //this step is necessary for the case where there are finite coins
        Arrays.sort(num);

        //remember the traces to an entry using string encoding
        //if we only care about the NUMBER of ways, we don't need this
        String[][] hist = new String[size][target + 1];

        for (int i = 1; i <= target; i++) {//fill the DP matrix column by column
            for (int j = 0; j < size; j++) {
                StringBuilder sb = new StringBuilder();
                //case 1, if this candidate is the 1st of its kind
                if (j == 0 || (num[j] != num[j - 1])) {
                    if (num[j] == i) {
                        sb.append(Integer.toString(i) + ",");
                    } else {
                        int delta = num[j];
                        if ((i - delta) > 0) {
                            for (int k = 0; k < j; k++) {
                                if (hist[k][i - delta] != null) {
                                    String[] old = hist[k][i - delta].split(",");
                                    for (String s : old) {
                                        sb.append(s + " " + Integer.toString(num[j]));
                                        sb.append(",");
                                    }
                                }
                            }
                        }
                    }
                }
                //case 2, this candidate is the 2nd or later of its kind
                else {
                    int delta = num[j];
                    if ((i - delta) > 0 && (hist[j - 1][i - delta] != null)) {
                        String[] old = hist[j - 1][i - delta].split(",");
                        for (String s : old) {
                            sb.append(s + " " + Integer.toString(num[j]));
                            sb.append(",");
                        }
                    }

                }
                if (sb.length() > 0) {
                    hist[j][i] = sb.substring(0, sb.length() - 1);
                    //System.out.println(num[j] + " " + i + ": " + hist[j][i]);
                }
            }
        }

        for (int j = 0; j < size; j++) {
            if (hist[j][target] != null) {
                String[] ss = hist[j][target].split(",");
                for (String s : ss) {
                    String[] cc = s.trim().split("\\s+");
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    for (String c : cc) {
                        temp.add(Integer.parseInt(c));
                    }
                    result.add(temp);
                }
            }
        }

        return result;
    }

}
