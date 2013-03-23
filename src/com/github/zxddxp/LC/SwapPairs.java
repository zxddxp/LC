package com.github.zxddxp.LC;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null) {
			return head;
		}

		if (head.next == null) {
			return head;
		}

		ListNode newHead = head;
		ListNode first = head;
		ListNode tail = null;
		while (first != null && first.next != null) {
			ListNode temp = first.next.next;
			if (tail == null) {
				newHead = first.next;
			}
			else {
				tail.next = first.next;
			} 
			tail = first;
			first.next.next = first;
			first.next = temp;
			first = temp;
		}

		return newHead;
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
