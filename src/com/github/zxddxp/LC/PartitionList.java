package com.github.zxddxp.LC;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (head == null) {
            return null;
        }
        ListNode left = null;
        ListNode right = null;
        ListNode lTail = null;
        ListNode rTail = null;
        while (head != null) {
            if (head.val < x) {
                if (left == null) {
                    left = lTail = head;
                } else {
                    lTail.next = head;
                    lTail = head;
                }
            } else {
                if (right == null) {
                    right = rTail = head;
                } else {
                    rTail.next = head;
                    rTail = head;
                }
            }
            head = head.next;
        }
        if (right != null) {
            rTail.next = null;
        }
        ListNode result = right;
        if (left != null) {
            lTail.next = result;
            result = left;
        }
        return result;
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
