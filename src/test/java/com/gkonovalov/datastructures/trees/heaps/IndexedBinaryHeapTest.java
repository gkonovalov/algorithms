package com.gkonovalov.datastructures.trees.heaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.gkonovalov.datastructures.trees.heaps.IndexedBinaryHeap.Type.MAX;
import static com.gkonovalov.datastructures.trees.heaps.IndexedBinaryHeap.Type.MIN;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Tests for {@link IndexedBinaryHeap}.
 * </p
 */
public class IndexedBinaryHeapTest {

    private IndexedBinaryHeap<Integer> minHeap;
    private IndexedBinaryHeap<Integer> maxHeap;

    @BeforeEach
    public void setUp() {
        this.minHeap = new IndexedBinaryHeap<>(MIN);
        this.maxHeap = new IndexedBinaryHeap<>(MAX);
    }

    @Test
    @DisplayName("Testing BinaryHeap.isEmpty")
    public void testIsEmpty() {
        assertTrue(minHeap.isEmpty());

        minHeap.insert(0, 5);

        assertFalse(minHeap.isEmpty());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.insert")
    public void testMinHeapInsert() {
        assertEquals(minHeap.size(), 0);

        minHeap.insert(0,5);
        minHeap.insert(1,1);
        minHeap.insert(2,-2);
        minHeap.insert(3,200);
        minHeap.insert(4,200);
        minHeap.insert(5,200);
        minHeap.insert(6,200);
        minHeap.insert(7,200);

        assertThrows(IllegalArgumentException.class, () -> minHeap.insert(7,200));
        assertEquals(minHeap.size(), 8);
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.peekKey")
    public void testMinHeapPeekKey() {
        assertEquals(minHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> minHeap.peekKey());

        minHeap.insert(0,5);
        minHeap.insert(1,1);
        minHeap.insert(2,-2);
        minHeap.insert(3,200);

        assertEquals(-2, minHeap.peekKey());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.pollIndex")
    public void testMinHeapPollIndex() {
        assertEquals(minHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> minHeap.pollIndex());

        minHeap.insert(0,5);
        minHeap.insert(1,1);
        minHeap.insert(2,200);
        minHeap.insert(3,-2);

        assertEquals(3, minHeap.pollIndex());
        assertEquals(1, minHeap.pollIndex());
        assertEquals(0, minHeap.pollIndex());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.pollKey")
    public void testMinHeapPollKey() {
        assertEquals(minHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> minHeap.pollKey());

        minHeap.insert(0,5);
        minHeap.insert(1,1);
        minHeap.insert(2,200);
        minHeap.insert(3,-2);

        assertEquals(-2, minHeap.pollKey());
        assertEquals(1, minHeap.pollKey());
        assertEquals(5, minHeap.pollKey());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.decreaseKey")
    public void testMinHeapDecreaseKey() {
        assertEquals(minHeap.size(), 0);

        minHeap.insert(0,5);
        minHeap.insert(1,1);
        minHeap.insert(2,200);
        minHeap.insert(3,-2);

        minHeap.decreaseKey(2, 2);

        assertEquals(-2, minHeap.pollKey());
        assertEquals(1, minHeap.pollKey());
        assertEquals(2, minHeap.pollKey());
    }

    @Test
    @DisplayName("Testing Min BinaryHeap.decreaseKey")
    public void testMinHeapIncreaseKey() {
        assertEquals(minHeap.size(), 0);

        minHeap.insert(0,5);
        minHeap.insert(1,1);
        minHeap.insert(2,200);
        minHeap.insert(3,-2);

        minHeap.increaseKey(3, 2);

        assertEquals(1, minHeap.pollKey());
        assertEquals(2, minHeap.pollKey());
        assertEquals(5, minHeap.pollKey());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.peekKey")
    public void testMaxHeapPeekKey() {
        assertEquals(maxHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> maxHeap.peekKey());

        maxHeap.insert(0,5);
        maxHeap.insert(1,1);
        maxHeap.insert(2,-2);
        maxHeap.insert(3,200);

        assertEquals(200, maxHeap.peekKey());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.pollIndex")
    public void testMaxHeapPollIndex() {
        assertEquals(maxHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> maxHeap.pollIndex());

        maxHeap.insert(0,5);
        maxHeap.insert(1,1);
        maxHeap.insert(2,200);
        maxHeap.insert(3,-2);

        assertEquals(2, maxHeap.pollIndex());
        assertEquals(0, maxHeap.pollIndex());
        assertEquals(1, maxHeap.pollIndex());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.pollKey")
    public void testMaxHeapPollKey() {
        assertEquals(maxHeap.size(), 0);
        assertThrows(IllegalStateException.class, () -> maxHeap.pollKey());

        maxHeap.insert(0,5);
        maxHeap.insert(1,1);
        maxHeap.insert(2,200);
        maxHeap.insert(3,-2);

        assertEquals(200, maxHeap.pollKey());
        assertEquals(5, maxHeap.pollKey());
        assertEquals(1, maxHeap.pollKey());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.decreaseKey")
    public void testMaxHeapDecreaseKey() {
        assertEquals(maxHeap.size(), 0);

        maxHeap.insert(0,5);
        maxHeap.insert(1,1);
        maxHeap.insert(2,200);
        maxHeap.insert(3,-2);

        maxHeap.decreaseKey(2, 2);

        assertEquals(5, maxHeap.pollKey());
        assertEquals(2, maxHeap.pollKey());
        assertEquals(1, maxHeap.pollKey());
    }

    @Test
    @DisplayName("Testing Max BinaryHeap.decreaseKey")
    public void testMaxHeapIncreaseKey() {
        assertEquals(maxHeap.size(), 0);

        maxHeap.insert(0,5);
        maxHeap.insert(1,1);
        maxHeap.insert(2,200);
        maxHeap.insert(3,-2);

        maxHeap.increaseKey(3, 2);

        assertEquals(200, maxHeap.pollKey());
        assertEquals(5, maxHeap.pollKey());
        assertEquals(2, maxHeap.pollKey());
    }
}
