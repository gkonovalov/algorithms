package com.gkonovalov.datastructures.trees;

import com.gkonovalov.datastructures.etc.TreeNode;

/**
 * Created by Georgiy Konovalov on 14/06/2023.
 * <p>
 * Binary Search Tree data structure implementation.  A binary search tree is a specific type of binary
 * tree that follows a strict ordering property. In a BST, the left subtree of a node contains only nodes
 * with values less than the node's value, and the right subtree contains only nodes with values greater
 * than the node's value. This ordering property holds recursively for all nodes in the tree.
 * The ordering property of a BST allows for efficient searching. By comparing the value being searched
 * with the values at each node, the search operation can eliminate half of the remaining nodes at each
 * step, resulting in a time complexity of O(log n) on average for search operations.
 * If the BST becomes highly unbalanced, with significant differences in the number of nodes between the
 * left and right subtrees, the tree's height can become closer to linear, rather than logarithmic. In
 * such cases, the time complexity of operations like search, insert, and delete can degrade to O(n)
 * instead of the expected O(log n). This typically happens when the elements are inserted in a sorted
 * or nearly sorted order, causing the tree to skew.
 * To mitigate these performance issues, various balancing techniques and self-balancing
 * binary search tree implementations, such as AVL trees, Red-Black trees, or B-trees, are used.
 * </p>
 * Runtime Complexity: O(log n) average case and O(n) worst case for
 *                          {@code add}, {@code get}, {@code remove},
 *                          {@code contains}, {@code findMin}, {@code findMax},
 *                     O(1) for {@code isEmpty}, {@code size}.
 * Space Complexity:   O(n).
 */
public class BinarySearchTree {

    private TreeNode root;
    private int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    public void add(int val) {
        size++;
        root = insertNode(root, val);
    }

    public TreeNode get(int value) {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Search Tree is empty!");
        }

        return searchNode(root, value);
    }

    public void remove(int value) {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Search Tree is empty!");
        }

        size--;
        root = deleteNode(root, value);
    }

    public boolean contains(int value) {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Search Tree is empty!");
        }

        return searchNode(root, value) != null;
    }

    public int findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Search Tree is empty!");
        }

        TreeNode maxNode = findMin(root);
        if (maxNode != null) {
            return maxNode.value;
        }
        return -1;
    }

    public int findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Search Tree is empty!");
        }

        TreeNode maxNode = findMax(root);
        if (maxNode != null) {
            return maxNode.value;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    private TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    private TreeNode searchNode(TreeNode root, int value) {
        if (root == null) {
            return root;
        }

        if (value == root.value) {
            return root;
        }

        if (value < root.value) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }

    private TreeNode deleteNode(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else if (node.left != null && node.right != null) {
            node.value = findMin(node.right).value;
            node.right = deleteNode(node.right, node.value);
        } else {
            return node.left == null ? node.right : node.left;
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
