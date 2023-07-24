package com.gkonovalov.problems.tree;


import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">
 *          [Hard][124] - Binary Tree Maximum Path Sum
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code maxPathSum}.
 * Space Complexity:   O(n) for {@code maxPathSum}.
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }

    private static int maxPath = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int currPath = left + right + root.val;
        maxPath = Math.max(currPath, maxPath);

        return Math.max(left, right) + root.val;
    }
}
