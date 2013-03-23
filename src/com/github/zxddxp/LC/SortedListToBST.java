package com.github.zxddxp.LC;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null) {
			return null;
		}

		int size = 1;
		ListNode n = head;
		while (n.next != null) {
			size++;
			n = n.next;
		}

		TreeNode result = buildTree(0,size-1);

		inOrder(result, head);

		return result;
	}

	public ListNode inOrder(TreeNode t, ListNode n) {

		if (t.left != null) {
			n = inOrder(t.left,n);
		}
		t.val = n.val;
		n = n.next;
		if (t.right != null) {
			n = inOrder(t.right,n);
		}
		return n;
	}

	public TreeNode buildTree(int start, int end) {
		if (start > end) {
			return null;
		}
		else if (start == end) {
			return new TreeNode(start);
		}
		else {
			int mid = (start+end)/2;
			TreeNode root = new TreeNode(mid);
			root.left = buildTree(start, mid-1);
			root.right = buildTree(mid+1, end);
			return root;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}


}
