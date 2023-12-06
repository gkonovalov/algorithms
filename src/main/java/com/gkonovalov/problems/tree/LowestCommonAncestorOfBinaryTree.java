package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

    public TreeNode lowestCommonAncestorIteration(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        parent.put(root, null);
        stack.add(root);

        while (!parent.containsKey(p) && !parent.containsKey(q)) {
            TreeNode curr = stack.pop();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                stack.add(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                stack.add(curr.right);
            }
        }

        Set<TreeNode> anc = new HashSet<>();

        while (p != null) {
            anc.add(p);
            p = parent.get(p);
        }

        while (!anc.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
