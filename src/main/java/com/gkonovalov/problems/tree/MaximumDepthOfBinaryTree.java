package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.Node;
import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 10/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">
 *             [Easy][104] - Maximum Depth of Binary Tree
 *       </a>
 * </p>
 * Runtime Complexity: O(n) for {@code maxDepth}.
 * Space Complexity:   O(n) for {@code maxDepth}.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        System.out.println("Max depth:" + maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
