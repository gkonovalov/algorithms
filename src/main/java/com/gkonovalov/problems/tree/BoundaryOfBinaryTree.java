package com.gkonovalov.problems.tree;


import com.gkonovalov.problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/boundary-of-binary-tree/">
 *          [Medium][545] - Boundary of Binary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code boundaryOfBinaryTree}.
 * Space Complexity:   O(n) for {@code boundaryOfBinaryTree}.
 */
public class BoundaryOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(boundaryOfBinaryTree(root));
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        result.add(root.val);
        left(root.left, result);
        bottom(root.left, result);
        bottom(root.right, result);
        right(root.right, result);

        return result;
    }

    private static void left(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        result.add(root.val);

        if (root.left == null) {
            left(root.right, result);
        } else {
            left(root.left, result);
        }
    }

    private static void right(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right == null) {
            right(root.left, result);
        } else {
            right(root.right, result);
        }

        result.add(root.val);
    }

    private static void bottom(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
        }

        bottom(root.left, result);
        bottom(root.right, result);
    }
}
