package com.github.zxddxp.LC;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n <= 0) {
			return head;
		}

		ListNode left, right;
		left = right = head;
		while ( n-- > 0 ) {
			right = right.next;
		}
		if (right == null) {
			return head.next;
		}

		while (right.next != null) {
			right = right.next;
			left = left.next;
		}
		left.next = left.next.next;

		return head;

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
