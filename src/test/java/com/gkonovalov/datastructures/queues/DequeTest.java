package com.gkonovalov.datastructures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link Deque}.
 * </p
 */
public class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    public void setUp() {
        this.deque = new Deque<>();
    }

    @Test
    @DisplayName("Testing Deque.isEmpty")
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());

        deque.addFirst(5);

        assertFalse(deque.isEmpty());
    }

    @Test
    @DisplayName("Testing Deque.addFirst")
    public void testAddFirst() {
        assertEquals(deque.size(), 0);

        deque.addFirst(5);

        assertEquals(deque.size(), 1);
        assertEquals(deque.removeFirst(), 5);
        assertThrows(IllegalStateException.class, () -> deque.removeLast());
        assertEquals(deque.size(), 0);
    }

    @Test
    @DisplayName("Testing Deque.addLast")
    public void testAddLast() {
        assertEquals(deque.size(), 0);

        deque.addLast(5);

        assertEquals(deque.size(), 1);
        assertEquals(deque.removeLast(), 5);
        assertThrows(IllegalStateException.class, () -> deque.removeFirst());
        assertEquals(deque.size(), 0);
    }

    @Test
    @DisplayName("Testing Deque.peekLast")
    public void testPeekLast() {
        assertEquals(deque.size(), 0);

        deque.addLast(5);

        assertEquals(deque.size(), 1);
        assertEquals(deque.peekLast(), 5);
    }

    @Test
    @DisplayName("Testing Deque.peekFirst")
    public void testPeekFirst() {
        assertEquals(deque.size(), 0);

        deque.addFirst(5);

        assertEquals(deque.size(), 1);
        assertEquals(deque.peekFirst(), 5);
    }

    @Test
    @DisplayName("Testing Queue.size")
    public void testSize() {
        assertEquals(deque.size(), 0);

        deque.addFirst(5);
        deque.addLast(2);

        assertEquals(deque.size(), 2);
    }

}
