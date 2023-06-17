package com.gkonovalov.datastructures.trees;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for the Binary Tree construction.
 * Binary tree is a hierarchical data structure in which each node has at most two children,
 * referred to as the left child and the right child. The binary tree follows a parent-child
 * relationship, where each node (except the root) has a parent node. The parent node is the
 * node from which a given node is directly accessible. Starting from the root node, every node
 * in the tree is reachable through a unique path. Each node in a binary tree can have at most
 * two children. The left child is typically smaller (or equal) in value compared to the parent
 * node, and the right child is greater in value.
 * Binary trees come in various forms, such as balanced binary trees (AVL trees, Red-Black trees)
 * and unbalanced binary trees (Binary Search Tree).
 * </p>
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(){}

    public TreeNode(T value) {
        this.value = value;
    }
}

