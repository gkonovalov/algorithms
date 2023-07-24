package com.gkonovalov.problems.tree;


import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">
 *          [Easy][226] - Invert Binary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code invertTree}.
 * Space Complexity:   O(n) for {@code invertTree}.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;

        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
