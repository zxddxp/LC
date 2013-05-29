package com.github.zxddxp.LC;

import java.util.ArrayList;

public class GeneratePascal {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(numRows);
        if (numRows == 0) {
            return result;
        }

        ArrayList<Integer> al;
        for (int i = 0; i < numRows; i++) {
            al = new ArrayList<Integer>();
            result.add(al);
        }

        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            al = result.get(i - 1);
            result.get(i).add(1);
            for (int j = 0; j < al.size() - 1; j++) {
                result.get(i).add(al.get(j) + al.get(j + 1));
            }
            result.get(i).add(1);
        }
        return result;
    }

}
