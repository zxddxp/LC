package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return result;
        }

        TreeNode n = root;
        while (n != null) {
            stack.push(n);
            n = n.left;
        }

        while (!stack.isEmpty()) {
            n = stack.pop();
            result.add(n.val);
            n = n.right;
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
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
