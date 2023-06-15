package com.gkonovalov.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Tests for {@link BinarySearchTree}.
 * </p
 */
public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    public void setUp() {
        this.bst = new BinarySearchTree();
    }

    @Test
    @DisplayName("Testing BinarySearchTree.isEmpty")
    public void testIsEmpty() {
        assertTrue(bst.isEmpty());

        bst.add(5);

        assertFalse(bst.isEmpty());

        bst.remove(5);

        assertTrue(bst.isEmpty());
    }

    @Test
    @DisplayName("Testing BinarySearchTree.add")
    public void testAdd() {
        assertTrue(bst.isEmpty());

        bst.add(5);
        bst.add(1);
        bst.add(-2);
        bst.add(200);
        bst.add(200);
        bst.add(200);
        bst.add(200);
        bst.add(200);

        assertEquals(bst.size(), 8);
    }

    @Test
    @DisplayName("Testing BinarySearchTree.get")
    public void testGet() {
        assertTrue(bst.isEmpty());
        assertThrows(IllegalStateException.class, () -> bst.get(0));

        bst.add(5);
        bst.add(1);
        bst.add(-2);
        bst.add(200);

        assertEquals(200, bst.get(200).value);
    }

    @Test
    @DisplayName("Testing BinarySearchTree.contains")
    public void testContains() {
        assertTrue(bst.isEmpty());
        assertThrows(IllegalStateException.class, () -> bst.contains(20));

        bst.add(5);
        bst.add(1);
        bst.add(-2);
        bst.add(200);

        assertTrue(bst.contains(-2));
        assertFalse(bst.contains(-20));
    }

    @Test
    @DisplayName("Testing BinarySearchTree.remove")
    public void testRemove() {
        assertTrue(bst.isEmpty());
        assertThrows(IllegalStateException.class, () -> bst.remove(0));

        bst.add(5);

        assertTrue(bst.contains(5));

        bst.add(1);
        bst.add(-2);
        bst.add(200);

        bst.remove(5);

        assertFalse(bst.contains(5));
    }

    @Test
    @DisplayName("Testing BinarySearchTree.findMin")
    public void testFindMin() {
        assertTrue(bst.isEmpty());
        assertThrows(IllegalStateException.class, () -> bst.findMin());

        bst.add(5);
        bst.add(1);
        bst.add(-2);
        bst.add(200);

        assertEquals(-2, bst.findMin());
    }

    @Test
    @DisplayName("Testing BinarySearchTree.findMax")
    public void testFindMax() {
        assertTrue(bst.isEmpty());
        assertThrows(IllegalStateException.class, () -> bst.findMax());

        bst.add(5);
        bst.add(1);
        bst.add(-2);
        bst.add(200);

        assertEquals(200, bst.findMax());
    }
}
