package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 10/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/recover-binary-search-tree/">
 *          [Medium][99] - Recover Binary Search Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code recoverTree}.
 * Space Complexity:   O(n) for {@code recoverTree}.
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        recoverTree(root);
    }

    private static TreeNode n1;
    private static TreeNode n2;
    private static TreeNode prev;

    public static void recoverTree(TreeNode root) {
        dfs(root);

        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (n1 == null && (prev != null && prev.val >= root.val)) {
            n1 = prev;
        }

        if (n1 != null && (prev != null && prev.val >= root.val)) {
            n2 = root;
        }

        prev = root;
        dfs(root.right);
    }
}
