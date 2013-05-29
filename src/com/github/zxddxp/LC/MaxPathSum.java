package com.github.zxddxp.LC;

public class MaxPathSum {
    public int gMax;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            gMax = Integer.MIN_VALUE;
            maxHandler(root);
            return gMax;
        }

    }

    public int maxHandler(TreeNode n) {
        //note: this helper function does 2 things
        // (1) it solve the same problem at node n, updating gMax
        // (2) it computes the best single path (from n to n's descendents) ends at n, and return this value
        if (n == null) {
            return 0; //no affect on gMax, and 0 for function (2)
        } else if (n.left == null && n.right == null) {//base case, a leaf node
            if (n.val > gMax) {
                gMax = n.val;
            }
            return n.val;
        } else {
            int leftVal = maxHandler(n.left);
            int rightVal = maxHandler(n.right);
            int myMaxSinglePath;
            if (leftVal <= 0 && rightVal <= 0) {
                myMaxSinglePath = n.val;
            } else {
                myMaxSinglePath = Math.max(leftVal, rightVal) + n.val;
            }
            if (myMaxSinglePath > gMax) {
                gMax = myMaxSinglePath;
            }

            int myMaxDoublePath = leftVal + rightVal + n.val;
            if (myMaxDoublePath > gMax) {
                gMax = myMaxDoublePath;
            }

            return myMaxSinglePath;
        }
    }

    public int maxPathSum_Failed_Large(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return 0;
        } else {
            int sum = root.val;
            if (root.left != null) {
                sum = Math.max(sum, maxPathSum(root.left));
            }
            if (root.right != null) {
                sum = Math.max(sum, maxPathSum(root.right));
            }
            sum = Math.max(sum, root.val + maxToRoot(root.left) + maxToRoot(root.right));

            return sum;
        }

    }

    public int maxToRoot(TreeNode n) {
        if (n == null) {
            return 0;
        } else {
            int sum = maxToRoot(n.left);
            sum = Math.max(sum, maxToRoot(n.right));
            return Math.max(0, n.val + sum);
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

