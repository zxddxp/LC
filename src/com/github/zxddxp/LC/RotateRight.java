package com.github.zxddxp.LC;

public class RotateRight {
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null	) {
			return null;
		}

		ListNode node = head;
		int total = 0;
		while (node != null) {
			total++;
			node = node.next;
		}
		n = n % total;

		ListNode left = head;
		ListNode right = head;
		while ( n > 0 && right.next != null) {
			right = right.next;
			n--;
		}
		if (n > 0) {//sanity check
			return head;
		}

		while (right.next != null) {
			right = right.next;
			left = left.next;
		}

		right.next = head;
		head = left.next;
		left.next = null;

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
