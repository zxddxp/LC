package com.github.zxddxp.LC;

public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (p == null && q == null) {
			return true;
		}
		else if (p == null || q == null) {
			return false;
		}
		else if (p.val != q.val) {
			return false;
		}
		else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
