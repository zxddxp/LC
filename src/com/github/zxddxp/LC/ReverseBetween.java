package com.github.zxddxp.LC;

public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null) {
			return null;
		}
		if (m == n) {
			return head;
		}

		ListNode leftTail = null;
		ListNode rightHead = null;
		ListNode mTh = null;
		ListNode nTh = null;
		//first, cut at the m-th node
		if ( m != 1 ) {
			leftTail = head;
			for (int i = 2; i < m; i++) {
				leftTail = leftTail.next;
			}
			mTh = leftTail.next;
		}
		else {
			mTh = head;
		}

		//second, reverse m -- n
		ListNode previous = mTh;
		rightHead = mTh.next;
		for (int i = m; i < n; i++) {
			nTh = rightHead;
			rightHead = nTh.next;
			nTh.next = previous;
			previous = nTh;
		}

		//third, stick the 3 segments back to a list
		mTh.next = rightHead;
		if (m != 1) {
			leftTail.next = nTh;
		}
		else {
			head = nTh;
		}

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
