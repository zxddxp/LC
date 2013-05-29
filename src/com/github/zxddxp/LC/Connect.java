package com.github.zxddxp.LC;

public class Connect {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }

        while (root.left != null) {
            TreeLinkNode n = root.left;
            root.left.next = root.right;
            TreeLinkNode tail = root.right;
            while ((root = root.next) != null) {
                tail.next = root.left;
                root.left.next = root.right;
                tail = root.right;
            }
            root = n;
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
