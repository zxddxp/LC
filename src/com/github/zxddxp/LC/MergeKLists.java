package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ListNode result = null;
		ListNode last = null;
		if (lists == null || lists.size() == 0) {
			return result;
		}
		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				pq.add(new pair(lists.get(i).val, i));
				lists.set(i, lists.get(i).next);
			}
		}
		pair p;
		while ((p = pq.poll()) != null) {
			ListNode l = new ListNode(p.val);
			if (result == null) {
				result = last = l;
			}
			else {
				last.next = l;
				last = l;
			}
			int i = p.id;
			if (lists.get(i) != null) {
				pq.add(new pair(lists.get(i).val, i));
				lists.set(i, lists.get(i).next);
			}
		}
		return result;
	}

	public class pair implements Comparable<pair> {
		int val;
		int id;
		pair (int x, int y) {
			val = x;
			id = y;
		}
		public int compareTo(pair other) {
			// TODO Auto-generated method stub
			if (val != other.val) {
				return val - other.val;
			}
			else {
				return id - other.id;
			}
		}
	}


	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
