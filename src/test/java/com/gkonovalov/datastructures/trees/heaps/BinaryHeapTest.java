package com.gkonovalov.datastructures.trees.heaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Tests for {@link BinaryHeap}.
 * </p
 */
public class BinaryHeapTest {

    private BinaryHeap<Integer> minHeap;
    private BinaryHeap<Integer> maxHeap;

    @BeforeEach
    public void setUp() {
        this.minHeap = new BinaryHeap<Integer>(Comparator.reverseOrder());
        this.maxHeap = new BinaryHeap<>();
    }

    @Test
    @DisplayName("Testing BinaryHeap.isEmpty")
    public void testIsEmpty() {
        assertTrue(minHeap.isEmpty());

        minHeap.add(5);

        assertFalse(minHeap.isEmpty());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.add")
    public void testMinHeapAdd() {
        assertEquals(minHeap.size(), 0);

        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(-2);
        minHeap.add(200);
        minHeap.add(200);
        minHeap.add(200);
        minHeap.add(200);
        minHeap.add(200);

        assertThrows(IllegalStateException.class, () -> minHeap.add(200));
        assertEquals(minHeap.size(), 8);
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.peek")
    public void testMinHeapPeek() {
        assertEquals(minHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> minHeap.peek());

        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(-2);
        minHeap.add(200);

        assertEquals(-2, minHeap.peek());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.poll")
    public void testMinHeapPoll() {
        assertEquals(minHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> minHeap.poll());

        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(-2);
        minHeap.add(200);

        assertEquals(-2, minHeap.poll());
        assertEquals(1, minHeap.poll());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.peek")
    public void testMaxHeapPeek() {
        assertEquals(maxHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> maxHeap.peek());

        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(-2);
        maxHeap.add(200);

        assertEquals(200, maxHeap.peek());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.poll")
    public void testMaxHeapPoll() {
        assertEquals(maxHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> maxHeap.poll());

        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(-2);
        maxHeap.add(200);

        assertEquals(200, maxHeap.poll());
        assertEquals(5, maxHeap.poll());
    }
}
