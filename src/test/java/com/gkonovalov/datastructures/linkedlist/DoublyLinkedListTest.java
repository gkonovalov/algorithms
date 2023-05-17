package com.gkonovalov.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link DoublyLinkedList}.
 * </p
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList<String> doublyLinkedList;

    @BeforeEach
    public void setUp() {
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    @DisplayName("Testing DoublyLinkedList.add")
    public void testAdd() {
        assertTrue(doublyLinkedList.isEmpty());

        doublyLinkedList.add("a");
        doublyLinkedList.add("b");

        assertEquals(doublyLinkedList.size(), 2);
        assertEquals(doublyLinkedList.get(0), "a");
        assertEquals(doublyLinkedList.get(1), "b");
    }

    @Test
    @DisplayName("Testing DoublyLinkedList.get")
    public void testGet() {
        assertThrows(IllegalArgumentException.class, () -> doublyLinkedList.get(10));

        doublyLinkedList.add("a");

        assertEquals(doublyLinkedList.get(0), "a");
        assertEquals(doublyLinkedList.size(), 1);
    }

    @Test
    @DisplayName("Testing DoublyLinkedList.remove")
    public void testRemove() {
        assertEquals(doublyLinkedList.size(), 0);

        doublyLinkedList.add("a");

        assertEquals(doublyLinkedList.size(), 1);
        assertTrue(doublyLinkedList.contains("a"));

        doublyLinkedList.remove(0);

        assertFalse(doublyLinkedList.contains("a"));
        assertTrue(doublyLinkedList.isEmpty());

        assertThrows(IllegalArgumentException.class, () -> doublyLinkedList.remove(10));
    }

    @Test
    @DisplayName("Testing DoublyLinkedList.contains")
    public void testContains() {
        doublyLinkedList.add("a");

        assertTrue(doublyLinkedList.contains("a"));
        assertFalse(doublyLinkedList.contains("b"));
    }

    @Test
    @DisplayName("Testing DoublyLinkedList.size")
    public void testSize() {
        assertEquals(doublyLinkedList.size(), 0);

        doublyLinkedList.add("a");

        assertEquals(doublyLinkedList.size(), 1);
    }

    @Test
    @DisplayName("Testing DounlyLinkedList.indexOf")
    public void testIndexOf() {
        doublyLinkedList.add("a");
        doublyLinkedList.add("b");
        doublyLinkedList.add("c");

        assertEquals(doublyLinkedList.indexOf("c"), 2);
    }

}
