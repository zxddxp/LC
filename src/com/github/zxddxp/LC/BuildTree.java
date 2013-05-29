package com.github.zxddxp.LC;

public class BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int iLeft, int iRight, int pLeft, int pRight) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (iLeft > iRight) {
            return null;
        } else if (iLeft == iRight) {
            return new TreeNode(inorder[iLeft]);
        } else {
            TreeNode root = new TreeNode(postorder[pRight]);

            int i = iLeft;
            int j = pLeft;
            while (i <= iRight) {
                if (inorder[i] == postorder[pRight]) {
                    break;
                }
                i++;
                j++;
            }

            root.left = buildTree(inorder, postorder, iLeft, i - 1, pLeft, j - 1);
            root.right = buildTree(inorder, postorder, i + 1, iRight, j, pRight - 1);

            return root;
        }
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
