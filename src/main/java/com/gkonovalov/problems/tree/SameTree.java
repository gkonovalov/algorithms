package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.TreeNode;

/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/same-tree/">
 *          [Easy][100] - Same Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code isSameTree}.
 * Space Complexity:   O(n) for {@code isSameTree}.
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(isSameTree(root, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
