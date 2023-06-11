package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 18/05/2023.
 * <p>
 * Tests for {@link QuickSort}.
 * </p
 */
public class QuickSortTest {

    private QuickSort quickSort;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.quickSort = new QuickSort();
        this.arr = new int[]{40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing QuickSort.randomizedSort")
    public void testSort() {
        quickSort.randomizedSort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] < arr[i]);
        }
    }

    @Test
    @DisplayName("Testing QuickSort.fixedSort")
    public void testSort2() {
        quickSort.fixedSort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] < arr[i]);
        }
    }
}
