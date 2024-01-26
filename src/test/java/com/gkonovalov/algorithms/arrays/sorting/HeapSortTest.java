package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Georgiy Konovalov on 5/17/2024.
 * <p>
 * Tests for {@link HeapSort}.
 * </p
 */
public class HeapSortTest {

    private HeapSort heapSort;

    @BeforeEach
    public void setUp() {
        this.heapSort = new HeapSort();
    }

    @Test
    @DisplayName("Testing HeapSort.sort")
    public void testSort() {
        int[] arr = {40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        int[] expected = {-555, -2, -1, 3, 4, 5, 5, 13, 20, 25, 40, 42, 44, 53};

        heapSort.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
