package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">
 *          [Easy][94] - Binary Tree Inorder Traversal
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code isSameTree}.
 * Space Complexity:   O(n) for {@code isSameTree}.
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        inorderTraversal(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsInorder(root, result);
        return result;
    }

    private static void dfsInorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        dfsInorder(root.left, result);
        result.add(root.val);
        dfsInorder(root.right, result);
    }
}
