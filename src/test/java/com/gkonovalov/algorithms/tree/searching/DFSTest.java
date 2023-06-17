package com.gkonovalov.algorithms.tree.searching;

import com.gkonovalov.datastructures.trees.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Tests for {@link DFS}.
 * </p
 */
public class DFSTest {

    private DFS dfs;
    private TreeNode<Integer> tree;

    @BeforeEach
    public void setUp() {
        this.dfs = new DFS();

        TreeNode<Integer> root = new TreeNode<>(3);
        TreeNode<Integer> left = new TreeNode<>(1);
        TreeNode<Integer> right = new TreeNode<>(5);

        left.left = new TreeNode<>(0);
        left.right = new TreeNode<>(2);
        right.left = new TreeNode<>(4);

        root.left = left;
        root.right = right;

        this.tree = root;
    }

    @Test
    @DisplayName("Testing DFS.inorderRecursive")
    public void testInorderRecursive() {
        List<Integer> result = new ArrayList<>();

        dfs.inorderRecursive(tree, result);

        assertIterableEquals(List.of(0, 1, 2, 3, 4, 5), result);
    }

    @Test
    @DisplayName("Testing DFS.inorderIterative")
    public void testInorderIterative() {
        List<Integer> result = new ArrayList<>();

        dfs.inorderIterative(tree, result);

        assertIterableEquals(List.of(0, 1, 2, 3, 4, 5), result);
    }

    @Test
    @DisplayName("Testing DFS.preorderRecursive")
    public void testPreorderRecursive() {
        List<Integer> result = new ArrayList<>();

        dfs.preorderRecursive(tree, result);

        assertIterableEquals(List.of(3, 1, 0, 2, 5, 4), result);
    }

    @Test
    @DisplayName("Testing DFS.preorderIterative")
    public void testPreorderIterative() {
        List<Integer> result = new ArrayList<>();

        dfs.preorderIterative(tree, result);

        assertIterableEquals(List.of(3, 1, 0, 2, 5, 4), result);
    }

    @Test
    @DisplayName("Testing DFS.postorderRecursive")
    public void testPostorderRecursive() {
        List<Integer> result = new ArrayList<>();

        dfs.postorderRecursive(tree, result);

        assertIterableEquals(List.of(0, 2, 1, 4, 5, 3), result);
    }

    @Test
    @DisplayName("Testing DFS.postorderIterative")
    public void testPostorderIterative() {
        List<Integer> result = new ArrayList<>();

        dfs.postorderIterative(tree, result);

        assertIterableEquals(List.of(0, 2, 1, 4, 5, 3), result);
    }
}
