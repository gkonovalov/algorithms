package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link SelectionSort}.
 * </p
 */
public class SelectionSortTest {

    private SelectionSort selectionSort;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.selectionSort = new SelectionSort();
        this.arr = new int[]{40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing Selection Sort")
    public void testSort() {
        selectionSort.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] < arr[i]);
        }
    }
}
