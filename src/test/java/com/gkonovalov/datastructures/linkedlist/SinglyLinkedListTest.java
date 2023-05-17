package com.gkonovalov.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link SinglyLinkedList}.
 * </p
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList<String> singlyLinkedList;

    @BeforeEach
    public void setUp() {
        this.singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("Testing SinglyLinkedList.add")
    public void testAdd() {
        assertTrue(singlyLinkedList.isEmpty());

        singlyLinkedList.add("a");
        singlyLinkedList.add("b");

        assertEquals(singlyLinkedList.size(), 2);
        assertEquals(singlyLinkedList.get(0), "a");
        assertEquals(singlyLinkedList.get(1), "b");
    }

    @Test
    @DisplayName("Testing SinglyLinkedList.get")
    public void testGet() {
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.get(10));

        singlyLinkedList.add("a");

        assertEquals(singlyLinkedList.get(0), "a");
        assertEquals(singlyLinkedList.size(), 1);
    }

    @Test
    @DisplayName("Testing SinglyLinkedList.remove")
    public void testRemove() {
        assertEquals(singlyLinkedList.size(), 0);

        singlyLinkedList.add("a");

        assertEquals(singlyLinkedList.size(), 1);
        assertTrue(singlyLinkedList.contains("a"));

        singlyLinkedList.remove(0);

        assertFalse(singlyLinkedList.contains("a"));
        assertTrue(singlyLinkedList.isEmpty());

        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.remove(10));
    }

    @Test
    @DisplayName("Testing SinglyLinkedList.contains")
    public void testContains() {
        singlyLinkedList.add("a");

        assertTrue(singlyLinkedList.contains("a"));
        assertFalse(singlyLinkedList.contains("b"));
    }

    @Test
    @DisplayName("Testing SinglyLinkedList.size")
    public void testSize() {
        assertEquals(singlyLinkedList.size(), 0);

        singlyLinkedList.add("a");

        assertEquals(singlyLinkedList.size(), 1);
    }

    @Test
    @DisplayName("Testing SinglyLinkedList.indexOf")
    public void testIndexOf() {
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        singlyLinkedList.add("c");

        assertEquals(singlyLinkedList.indexOf("c"), 2);
    }

}
