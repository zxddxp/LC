package com.github.zxddxp.LC;

public class Flatten {

    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (root == null) {
            return;
        }
        root = toFlat(root, null);
    }

    public TreeNode toFlat(TreeNode n, TreeNode sub) {
        if (n.right != null) {
            sub = toFlat(n.right, sub);
        }
        if (n.left != null) {
            sub = toFlat(n.left, sub);
        }
        n.left = null;
        n.right = sub;
        return n;
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
