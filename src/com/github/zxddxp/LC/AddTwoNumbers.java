package com.github.zxddxp.LC;

public class AddTwoNumbers {


	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ListNode result = null;
		ListNode itr = null;

		int carry = 0;
		while (l1 != null || l2 != null) {
			int i1 = 0;
			int i2 = 0;
			if (l1  != null) {
				i1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				i2 = l2.val;
				l2 = l2.next;
			}
			int sum = i1 + i2 + carry;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			if (result == null) {
				result = new ListNode(sum);
				itr = result;
			}
			else {
				itr.next = new ListNode(sum);
				itr = itr.next;
			}
		}
		if (carry == 1) {
			if (result == null) {
				result = new ListNode(1);
				itr = result;
			}
			else {
				itr.next = new ListNode(1);
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
