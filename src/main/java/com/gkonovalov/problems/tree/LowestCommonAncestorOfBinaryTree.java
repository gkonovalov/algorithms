package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">
 *          [Medium][263] - Lowest Common Ancestor of a Binary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code lowestCommonAncestor}.
 * Space Complexity:   O(n) for {@code lowestCommonAncestor}.
 */
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        right.right = new TreeNode(20);
        right.left = new TreeNode(9);
        root.right = right;

        lowestCommonAncestor(root, root.left, root.right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
