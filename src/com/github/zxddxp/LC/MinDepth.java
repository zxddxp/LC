    package com.github.zxddxp.LC;

    public class MinDepth {
        public int minDepth(TreeNode root) {
            // Start typing your Java solution below
            // DO NOT write main() function

            if (root == null) {
                return 0;
            }
            else if (root.left == null && root.right == null) {
                return 1;
            }
            else if (root.left == null) {
                return 1 + minDepth(root.right);
            }
            else if (root.right == null) {
                return 1 + minDepth(root.left);
            }
            else {
                return 1 + Math.min(minDepth(root.left), minDepth(root.right));
            }
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }


    }
