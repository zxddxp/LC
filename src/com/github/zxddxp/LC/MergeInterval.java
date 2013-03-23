package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (intervals == null || intervals.size() == 0 || intervals.size() == 1) {
			return intervals;
		}
		IntervalComparator ic = new IntervalComparator();
		Collections.sort(intervals, ic);
		ArrayList<Interval> result = new ArrayList<Interval>();
		int head = intervals.get(0).start;
		int tail = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= tail) {
				tail = Math.max(tail, intervals.get(i).end);
			}
			else {
				result.add(new Interval(head, tail));
				head = intervals.get(i).start;
				tail = intervals.get(i).end;
			}
		}
		result.add(new Interval(head,tail));

		return result;
	}

	public class IntervalComparator implements Comparator<Interval> {

		public int compare(Interval i1, Interval i2) {
			// TODO Auto-generated method stub
			if (i1.start != i2.start) {
				return i1.start - i2.start;
			}
			else {
				return i1.end - i2.end;
			}
		}

	}

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
