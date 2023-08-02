package com.gkonovalov.problems.tree;


import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">
 *          [Medium][98] - Validate Binary Search Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code isValidBST}.
 * Space Complexity:   O(n) for {@code isValidBST}.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public static boolean isValid(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }

        if ((max != null && max <= root.val) || (min != null && min >= root.val)) {
            return false;
        }

        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
}
