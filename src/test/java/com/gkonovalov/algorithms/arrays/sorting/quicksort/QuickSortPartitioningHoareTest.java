package com.gkonovalov.algorithms.arrays.sorting.quicksort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 5/18/2023.
 * <p>
 * Tests for {@link QuickSortPartitionHoare}.
 * </p
 */
public class QuickSortPartitioningHoareTest {

    private QuickSortPartitionHoare quickSort;

    @BeforeEach
    public void setUp() {
        this.quickSort = new QuickSortPartitionHoare();
    }

    @Test
    @DisplayName("Testing QuickSortPartitionHoare.sort")
    public void testRandomizedSortHoare() {
        int[] arr = {40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        int[] expected = {-555, -2, -1, 3, 4, 5, 5, 13, 20, 25, 40, 42, 44, 53};

        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
