package com.github.zxddxp.LC;

import java.util.ArrayList;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> last = new ArrayList<TreeNode>();
        last.add(root);

        while (last.size() != 0) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (TreeNode n : last) {
                level.add(n.val);
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
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
