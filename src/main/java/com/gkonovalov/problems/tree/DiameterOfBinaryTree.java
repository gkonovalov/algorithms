package com.gkonovalov.problems.tree;


import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">
 *          [Easy][543] - Diameter of Binary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code diameterOfBinaryTree}.
 * Space Complexity:   O(n) for {@code diameterOfBinaryTree}.
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        diameterOfBinaryTree(root);
    }

    private static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
