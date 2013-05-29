package com.github.zxddxp.LC;

import java.util.ArrayList;

public class FullJustify {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<String> result = new ArrayList<String>();
        if (words == null) {
            return result;
        }
        if (words.length == 0) {
            result.add("");
            return result;
        }
        if (words.length == 1) {
            StringBuilder sb = new StringBuilder(words[0]);
            for (int k = 0; k < (L - words[0].length()); k++) {
                sb.append(" ");
            }
            result.add(sb.toString());
            return result;
        }

        int count = words[0].length();
        int gap = 0;
        int first = 0;
        int last = 0;
        while (++last < words.length) {
            String w = words[last];
            if ((count + gap + 1 + w.length()) > L) {
                StringBuilder sb = new StringBuilder();
                if (gap == 0) { //a line with a single word
                    sb.append(words[first]);
                    for (int k = 0; k < (L - words[first].length()); k++) {
                        sb.append(" ");
                    }
                    result.add(sb.toString());
                } else {
                    int basicInc = (L - count) / gap;
                    int advancedInc = (L - count) % gap;
                    sb.append(words[first]);
                    while (++first < last) {
                        for (int k = 0; k < basicInc; k++) {
                            sb.append(" ");
                        }
                        if (advancedInc > 0) {
                            advancedInc--;
                            sb.append(" ");
                        }
                        sb.append(words[first]);
                    }
                    result.add(sb.toString());
                }

                first = last;
                count = words[last].length();
                gap = 0;
            } else {
                gap++;
                count += w.length();
            }

        }

        StringBuilder sbb = new StringBuilder();
        sbb.append(words[first]);
        while (++first < last) {
            sbb.append(" ");
            sbb.append(words[first]);
        }
        while (gap++ < (L - count)) {
            sbb.append(" ");
        }
        result.add(sbb.toString());

        return result;
    }

}
