package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Tests for {@link QuickSort3WayPartitioning}.
 * </p
 */
public class QuickSort3WayPartitioningTest {

    private QuickSort3WayPartitioning quickSort;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.quickSort = new QuickSort3WayPartitioning();
        this.arr = new int[]{40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing QuickSort3WayPartitioning.sort")
    public void testSort() {
        quickSort.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]);
        }
    }
}
