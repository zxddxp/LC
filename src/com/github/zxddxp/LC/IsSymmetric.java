package com.github.zxddxp.LC;

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (root == null) {
			return true;
		}
		else {
			return compare(root.left, root.right);
		}

	}

	public boolean compare(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		else if (left == null || right == null) {
			return false;
		}
		else if (left.val != right.val) {
			return false;
		}
		else {
			return compare(left.left, right.right) && compare(left.right, right.left);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
