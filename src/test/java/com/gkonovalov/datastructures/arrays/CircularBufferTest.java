package com.gkonovalov.datastructures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Tests for {@link CircularBuffer}.
 * </p
 */
public class CircularBufferTest {

    private CircularBuffer<Integer> circularBuffer;

    @BeforeEach
    public void setUp() {
        this.circularBuffer = new CircularBuffer<>(3);
    }

    @Test
    @DisplayName("Testing CircularBuffer.isEmpty")
    public void testIsEmpty() {
        assertTrue(circularBuffer.isEmpty());

        circularBuffer.enqueue(5);

        assertFalse(circularBuffer.isEmpty());
    }

    @Test
    @DisplayName("Testing CircularBuffer.enqueue")
    public void testEnqueue() {
        assertTrue(circularBuffer.isEmpty());

        circularBuffer.enqueue(1);
        circularBuffer.enqueue(2);
        circularBuffer.enqueue(3);
        circularBuffer.enqueue(4);

        assertTrue(circularBuffer.isFull());
        assertEquals(2, circularBuffer.dequeue());
        assertEquals(3, circularBuffer.dequeue());
        assertEquals(4, circularBuffer.dequeue());

        assertThrows(IllegalStateException.class, () -> circularBuffer.dequeue());
        assertTrue(circularBuffer.isEmpty());
    }

    @Test
    @DisplayName("Testing CircularBuffer.dequeue")
    public void testDequeue() {
        assertTrue(circularBuffer.isEmpty());

        circularBuffer.enqueue(5);
        circularBuffer.dequeue();

        assertThrows(IllegalStateException.class, () -> circularBuffer.dequeue());
        assertTrue(circularBuffer.isEmpty());
    }

    @Test
    @DisplayName("Testing CircularBuffer.isFull")
    public void testIsFull() {
        assertTrue(circularBuffer.isEmpty());

        circularBuffer.enqueue(1);
        circularBuffer.enqueue(2);
        circularBuffer.enqueue(3);

        assertTrue(circularBuffer.isFull());
    }

    @Test
    @DisplayName("Testing CircularBuffer.size")
    public void testSize() {
        assertTrue(circularBuffer.isEmpty());

        circularBuffer.enqueue(1);
        circularBuffer.enqueue(2);
        assertEquals(2, circularBuffer.size());

        circularBuffer.enqueue(3);
        assertEquals(3, circularBuffer.size());

        assertTrue(circularBuffer.isFull());
    }

    @Test
    @DisplayName("Testing CircularBuffer.peek")
    public void testPeek() {
        assertTrue(circularBuffer.isEmpty());

        circularBuffer.enqueue(1);
        assertEquals(1, circularBuffer.peek());

        circularBuffer.enqueue(2);
        circularBuffer.dequeue();

        assertEquals(2, circularBuffer.peek());
    }
}
