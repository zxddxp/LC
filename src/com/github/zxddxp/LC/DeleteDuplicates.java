package com.github.zxddxp.LC;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (head == null) {
            return null;
        }

        ListNode result = head;
        ListNode tail = head;
        int lastVal = head.val;
        head = head.next;
        while (head != null) {
            if (head.val != lastVal) {
                tail.next = head;
                tail = head;
                lastVal = head.val;
            }
            head = head.next;
        }
        tail.next = null;
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
