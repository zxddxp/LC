package com.github.zxddxp.LC;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ListNode result = null;
        ListNode last = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            result = last = l1;
            l1 = l1.next;
        } else {
            result = last = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                last.next = l1;
                last = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                last = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            last.next = l1;
        } else {
            last.next = l2;
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
