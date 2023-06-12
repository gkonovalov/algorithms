package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 18/05/2023.
 * <p>
 * Tests for {@link MergeSort}.
 * </p
 */
public class MergeSortTest {

    private MergeSort mergeSort;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.mergeSort = new MergeSort();
        this.arr = new int[]{40, -2, 4, 44, 5, 42, 5, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing MergeSort.sort")
    public void testSort() {
        mergeSort.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]);
        }
    }

    @Test
    @DisplayName("Testing MergeSort.sort2")
    public void testSort2() {
        mergeSort.sort2(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]);
        }
    }
}
