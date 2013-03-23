package com.github.zxddxp.LC;

import java.util.ArrayList;

public class PathSum {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		hasPathSum(root, sum, result, path);
		return result;
	}

	public void hasPathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<TreeNode> path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		else if (root.left == null && root.right == null) {
			if (sum != root.val) {
				return;
			}
			ArrayList<Integer> p = new ArrayList<Integer>();
			for (TreeNode t : path) {
				p.add(t.val);
			}
			p.add(root.val);
			result.add(p);
		}
		else {
			path.add(root);
			sum -= root.val;
			hasPathSum(root.left, sum, result, path);
			hasPathSum(root.right, sum, result, path);
			path.remove(path.size()-1);
		}
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
