package com.github.zxddxp.LC;

public class BuildTree2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (iLeft > iRight) {
            return null;
        } else if (iLeft == iRight) {
            return new TreeNode(inorder[iLeft]);
        } else {
            TreeNode root = new TreeNode(preorder[pLeft]);

            int i = iLeft;
            int j = pLeft + 1;
            while (i <= iRight) {
                if (inorder[i] == preorder[pLeft]) {
                    break;
                }
                i++;
                j++;
            }

            root.left = buildTree(preorder, inorder, pLeft + 1, j - 1, iLeft, i - 1);
            root.right = buildTree(preorder, inorder, j, pRight, i + 1, iRight);

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
