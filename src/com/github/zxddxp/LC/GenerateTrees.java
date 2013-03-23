package com.github.zxddxp.LC;

import java.util.ArrayList;

public class GenerateTrees {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (n == 0) {
			result.add(null);
			return result;
		}
		else {
			ArrayList<ArrayList<TreeNode>> count = new ArrayList<ArrayList<TreeNode>>(n+1);
			for (int i = 0; i <= n; i++) {
				count.add(new ArrayList<TreeNode>());
			}
			count.get(0).add(null);
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					for (TreeNode n1 : count.get(j)) {
						for (TreeNode n2 : count.get(i - 1 - j)) {
							TreeNode t = new TreeNode(j+1);
							t.left = clone(n1,0);
							t.right = clone(n2, j+1);
							count.get(i).add(t);
						}
					}
				}
			}

			return count.get(n);
		}

	}

	public TreeNode clone(TreeNode t, int gap) {
		if (t == null) {
			return null;
		}
		else {
			TreeNode n = new TreeNode(t.val + gap);
			n.left = clone(t.left, gap);
			n.right = clone(t.right, gap);
			return n;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}

}
