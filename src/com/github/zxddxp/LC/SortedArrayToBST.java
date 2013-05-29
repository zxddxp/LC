package com.github.zxddxp.LC;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (num == null || num.length == 0) {
            return null;
        }

        return toArray(num, 0, num.length - 1);
    }

    public TreeNode toArray(int[] num, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(num[start]);
        } else {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = toArray(num, start, mid - 1);
            root.right = toArray(num, mid + 1, end);
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
