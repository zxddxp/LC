package com.github.zxddxp.LC;

import java.util.ArrayList;

public class InsertInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (intervals == null) {
            intervals = new ArrayList<Interval>(1);
            intervals.add(newInterval);
            return intervals;
        } else if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        } else if (intervals.get(0).start > newInterval.end) {
            intervals.add(0, newInterval);
            return intervals;
        }

        ArrayList<Interval> newInt = new ArrayList<Interval>();

        Interval it = null;
        int i = 0;
        while (i < intervals.size()) {
            it = intervals.get(i);
            if (it.end >= newInterval.start) {
                break;
            } else {
                newInt.add(it);
                i++;
            }
        }

        if (i == intervals.size()) {
            newInt.add(newInterval);
            return newInt;
        } else if (newInterval.end < it.start) {
            intervals.add(i, newInterval);
            return intervals;
        }

        int newStart = Math.min(it.start, newInterval.start);
        int newEnd = Math.max(it.end, newInterval.end);
        i++;
        while (i < intervals.size()) {
            it = intervals.get(i);
            if (it.start <= newEnd) {
                newEnd = Math.max(newEnd, it.end);
                i++;
            } else {
                break;
            }
        }
        newInt.add(new Interval(newStart, newEnd));

        while (i < intervals.size()) {
            newInt.add(intervals.get(i));
            i++;
        }

        return newInt;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return new String("[" + start + "," + end + "]");
        }
    }


}
