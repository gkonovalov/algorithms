package com.gkonovalov.algorithms.tree.searching;

import com.gkonovalov.datastructures.trees.TreeNode;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * BFS algorithm implementation. BFS stands for Breadth-First Search. It is a graph traversal
 * algorithm that explores all the vertices of a graph or all the nodes of a tree in
 * breadth-first order, i.e., it visits all the nodes at the same level (Level-order traversal)
 * before moving to the next level.
 * BFS guarantees that all nodes reachable from the source node will be visited, and the algorithm
 * visits nodes in increasing order of their distance from the source node.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(n).
 */
public class BFS {

    public void levelOrderIterative(TreeNode<Integer> root, LinkedList<List<Integer>> result) {
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());

            for (int i = queue.size(); i > 0; i--) {
                TreeNode<Integer> curr = queue.poll();

                result.getLast().add(curr.value);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    public void levelOrderRecursive(TreeNode<Integer> root, List<List<Integer>> result) {
        levelOrderRecursive(root, 0, result);
    }

    private void levelOrderRecursive(TreeNode<Integer> root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.value);

        levelOrderRecursive(root.left, level + 1, result);
        levelOrderRecursive(root.right, level + 1, result);
    }
}
