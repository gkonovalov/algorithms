package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link HeapSort}.
 * </p
 */
public class HeapSortTest {

    private HeapSort heapSort;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.heapSort = new HeapSort();
        this.arr = new int[]{40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing Heap Sort")
    public void testSort() {
        heapSort.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]);
        }
    }
}
