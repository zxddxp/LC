package com.github.zxddxp.LC;

public class IsBalanced {

	Boolean result = true;

	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		result = true;

		countLevel(root);

		return result;
	}

	private int countLevel(TreeNode n) {
		if (n == null) {
			return 0;
		}
		else {
			int leftCount = countLevel(n.left);
			int rightCount = countLevel(n.right);
			if (Math.abs(leftCount - rightCount) > 1) {
				result = false;
			}
			return 1 + Math.max(leftCount, rightCount);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
