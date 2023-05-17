package com.gkonovalov.datastructures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link Queue}.
 * </p
 */
public class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        this.queue = new Queue<>();
    }

    @Test
    @DisplayName("Testing Queue.isEmpty")
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.add(5);

        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Testing Queue.add")
    public void testAdd() {
        assertEquals(queue.size(), 0);

        queue.add(5);

        assertEquals(queue.size(), 1);
        assertEquals(queue.poll(), 5);
        assertEquals(queue.size(), 0);
    }

    @Test
    @DisplayName("Testing Queue.peek")
    public void testPeek() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
        assertEquals(queue.size(), 0);

        queue.add(5);

        assertEquals(queue.peek(), 5);
        assertEquals(queue.size(), 1);
    }

    @Test
    @DisplayName("Testing Queue.poll")
    public void testPoll() {
        assertThrows(IllegalStateException.class, () -> queue.poll());
        assertEquals(queue.size(), 0);

        queue.add(5);

        assertEquals(queue.poll(), 5);
        assertEquals(queue.size(), 0);
    }

    @Test
    @DisplayName("Testing Queue.size")
    public void testSize() {
        assertEquals(queue.size(), 0);

        queue.add(5);

        assertEquals(queue.size(), 1);
    }

}
