package com.github.zxddxp.LC;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (head == null) {
            return null;
        }

        ListNode result = null;
        ListNode tail = null;
        int lastVal = head.val;
        head = head.next;
        boolean hasDup = false;
        while (head != null) {
            if (head.val != lastVal) {
                if (hasDup) {
                    hasDup = false;
                } else {
                    if (tail == null) {
                        result = new ListNode(lastVal);
                        tail = result;
                    } else {
                        tail.next = new ListNode(lastVal);
                        tail = tail.next;
                    }
                }
                lastVal = head.val;
            } else {
                hasDup = true;
            }
            head = head.next;
        }
        if (!hasDup) {
            if (tail == null) {
                result = new ListNode(lastVal);
            } else {
                tail.next = new ListNode(lastVal);
            }
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
