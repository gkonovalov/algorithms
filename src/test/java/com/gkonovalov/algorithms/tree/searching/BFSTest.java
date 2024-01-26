package com.gkonovalov.algorithms.tree.searching;

import com.gkonovalov.datastructures.trees.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Tests for {@link BFS}.
 * </p
 */
public class BFSTest {

    private BFS bfs;
    private TreeNode<Integer> tree;

    @BeforeEach
    public void setUp() {
        this.bfs = new BFS();

        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> left = new TreeNode<>(2);
        TreeNode<Integer> right = new TreeNode<>(3);

        left.left = new TreeNode<>(4);
        left.right = new TreeNode<>(5);
        right.left = new TreeNode<>(6);

        root.left = left;
        root.right = right;

        this.tree = root;
    }

    @Test
    @DisplayName("Testing BFS.levelOrderIterative")
    public void testLevelOrderIterative() {
        LinkedList<List<Integer>> result = new LinkedList<>();

        bfs.levelOrderIterative(tree, result);

        assertIterableEquals(List.of(
                List.of(1),
                List.of(2, 3),
                List.of(4, 5, 6)
        ), result);
    }

    @Test
    @DisplayName("Testing BFS.levelOrderRecursive")
    public void testLevelOrderRecursive() {
        List<List<Integer>> result = new ArrayList<>();

        bfs.levelOrderRecursive(tree, result);

        assertIterableEquals(List.of(
                List.of(1),
                List.of(2, 3),
                List.of(4, 5, 6)
        ), result);
    }
}
