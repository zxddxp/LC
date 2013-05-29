package com.github.zxddxp.LC;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        boolean result = true;

        if (root == null) {
            return result;
        }

        pair p = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);

        return isValidBST(root, p);
    }

    public boolean isValidBST(TreeNode root, pair p) {
        //assert root != null
        p.min = root.val;
        p.max = root.val;
        if (root.left != null) {
            pair pp = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (!isValidBST(root.left, pp)) {
                return false;
            } else if (p.min <= pp.max) {
                return false;
            } else {
                p.min = pp.min;
            }
        }
        if (root.right != null) {
            pair pp = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (!isValidBST(root.right, pp)) {
                return false;
            } else if (p.max >= pp.min) {
                return false;
            } else {
                p.max = pp.max;
            }
        }

        return true;
    }

    public class pair {
        int min;
        int max;

        pair(int left, int right) {
            min = left;
            max = right;
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
