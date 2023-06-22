package com.gkonovalov.datastructures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Tests for {@link CircularQueue}.
 * </p
 */
public class CircularQueueTest {

    private CircularQueue<Integer> circularQueue;

    @BeforeEach
    public void setUp() {
        this.circularQueue = new CircularQueue<>(3);
    }

    @Test
    @DisplayName("Testing CircularQueue.isEmpty")
    public void testIsEmpty() {
        assertTrue(circularQueue.isEmpty());

        circularQueue.enqueue(5);

        assertFalse(circularQueue.isEmpty());
    }

    @Test
    @DisplayName("Testing CircularQueue.enqueue")
    public void testEnqueue() {
        assertTrue(circularQueue.isEmpty());

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);

        assertTrue(circularQueue.isFull());
        assertEquals(2, circularQueue.dequeue());
        assertEquals(3, circularQueue.dequeue());
        assertEquals(4, circularQueue.dequeue());

        assertThrows(IllegalStateException.class, () -> circularQueue.dequeue());
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    @DisplayName("Testing CircularQueue.dequeue")
    public void testDequeue() {
        assertTrue(circularQueue.isEmpty());

        circularQueue.enqueue(5);
        circularQueue.dequeue();

        assertThrows(IllegalStateException.class, () -> circularQueue.dequeue());
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    @DisplayName("Testing CircularQueue.isFull")
    public void testIsFull() {
        assertTrue(circularQueue.isEmpty());

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);

        assertTrue(circularQueue.isFull());
    }

    @Test
    @DisplayName("Testing CircularQueue.size")
    public void testSize() {
        assertTrue(circularQueue.isEmpty());

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        assertEquals(2, circularQueue.size());

        circularQueue.enqueue(3);
        assertEquals(3, circularQueue.size());

        assertTrue(circularQueue.isFull());
    }

    @Test
    @DisplayName("Testing CircularQueue.peek")
    public void testPeek() {
        assertTrue(circularQueue.isEmpty());

        circularQueue.enqueue(1);
        assertEquals(1, circularQueue.peek());

        circularQueue.enqueue(2);
        circularQueue.dequeue();

        assertEquals(2, circularQueue.peek());
        circularQueue.dequeue();

        assertThrows(IllegalStateException.class, () -> circularQueue.peek());
    }
}
