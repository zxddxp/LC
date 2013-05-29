package com.github.zxddxp.LC;

public class Connect2 {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        TreeLinkNode head = null;
        if (root.left != null) {
            head = root.left;
            if (root.right != null) {
                root.left.next = root.right;
            }
        } else {
            head = root.right;
        }

        while (head != null) {
            TreeLinkNode newHead = null;
            TreeLinkNode tail = null;
            while (head != null) {
                if (head.left != null) {
                    if (newHead == null) {
                        newHead = tail = head.left;
                    } else {
                        tail.next = head.left;
                        tail = head.left;
                    }
                }
                if (head.right != null) {
                    if (newHead == null) {
                        newHead = tail = head.right;
                    } else {
                        tail.next = head.right;
                        tail = head.right;
                    }
                }
                head = head.next;
            }
            head = newHead;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

}
