package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Georgiy Konovalov on 18/05/2023.
 * <p>
 * Tests for {@link MergeSort}.
 * </p
 */
public class MergeSortTest {

    private MergeSort mergeSort;

    @BeforeEach
    public void setUp() {
        this.mergeSort = new MergeSort();
    }

    @Test
    @DisplayName("Testing MergeSort.sort")
    public void testSort() {
        int[] arr = {40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        int[] expected = {-555, -2, -1, 3, 4, 5, 5, 13, 20, 25, 40, 42, 44, 53};

        mergeSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Testing MergeSort.sort2")
    public void testSort2() {
        int[] arr = {40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        int[] expected = {-555, -2, -1, 3, 4, 5, 5, 13, 20, 25, 40, 42, 44, 53};

        mergeSort.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
