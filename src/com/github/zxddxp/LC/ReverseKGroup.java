package com.github.zxddxp.LC;

public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null) {
			return null;
		}

		if (k == 1) {
			return head;
		}

		ListNode test = head;
		for (int i = 0; i < k-1; i++) {
			test = test.next;
			if (test == null) {
				return head;
			}
		}

		int kk = k;
		ListNode previous = head;
		ListNode rest = head.next;
		while (rest != null && --kk > 0) {
			ListNode temp = rest.next;
			rest.next = previous;
			previous = rest;
			rest = temp;
		}

		head.next = reverseKGroup(rest, k);
		return previous;

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
