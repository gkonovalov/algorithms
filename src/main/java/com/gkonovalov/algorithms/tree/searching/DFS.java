package com.gkonovalov.algorithms.tree.searching;

import com.gkonovalov.datastructures.trees.TreeNode;
import com.gkonovalov.datastructures.stack.Stack;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * DFS algorithm implementation. DFS stands for Depth-First Search. It is a graph traversal
 * algorithm that explores all the vertices (or nodes) of a graph or tree by going as far as
 * possible along each branch before backtracking. DFS can be implemented using either a
 * recursive approach or an iterative approach with the help of a stack data structure to keep
 * track of nodes to be visited.
 *
 * There are three different strategies for implementing DFS in the context of tree traversal,
 * each defining the order in which nodes are visited:
 *
 * Pre-order traversal  - Root-Left-Right
 * In-order traversal   - Left-Root-Right
 * Post-order traversal - Left-Right-Root
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(n).
 */
public class DFS {

    public void preorderRecursive(TreeNode<Integer> root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.value);
        preorderRecursive(root.left, path);
        preorderRecursive(root.right, path);
    }

    public void preorderIterative(TreeNode<Integer> root, List<Integer> path) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> current = stack.pop();

            path.add(current.value);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void inorderRecursive(TreeNode<Integer> root, List<Integer> path) {
        if (root == null) {
            return;
        }

        inorderRecursive(root.left, path);
        path.add(root.value);
        inorderRecursive(root.right, path);
    }

    public void inorderIterative(TreeNode<Integer> root, List<Integer> path) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            path.add(current.value);

            current = current.right;
        }
    }

    public void postorderRecursive(TreeNode<Integer> root, List<Integer> path) {
        if (root == null) {
            return;
        }

        postorderRecursive(root.left, path);
        postorderRecursive(root.right, path);
        path.add(root.value);
    }

    public void postorderIterative(TreeNode<Integer> root, List<Integer> path) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> current = stack.pop();

            path.add(0, current.value);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }
}
