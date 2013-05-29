package com.github.zxddxp.LC;

import java.util.ArrayList;


public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> last = new ArrayList<TreeNode>();
        last.add(root);
        boolean leftToRight = true;

        while (last.size() != 0) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            for (TreeNode n : last) {
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            ArrayList<Integer> level = new ArrayList<Integer>();
            if (leftToRight) {
                for (int i = 0; i < last.size(); i++) {
                    level.add(last.get(i).val);
                }
                leftToRight = false;
            } else {
                for (int i = last.size() - 1; i >= 0; i--) {
                    level.add(last.get(i).val);
                }
                leftToRight = true;
            }

            result.add(level);
            last = next;
        }

        return result;
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
