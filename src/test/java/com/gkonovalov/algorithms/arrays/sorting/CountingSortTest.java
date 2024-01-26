package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link CountingSort}.
 * </p
 */
public class CountingSortTest {

    private CountingSort countingSort;

    @BeforeEach
    public void setUp() {
        this.countingSort = new CountingSort();
    }

    @Test
    @DisplayName("Testing CountingSort.sortPositive")
    public void testSortPositive() {
        int[] arr = {40, 2, 4, 44, 5, 42, 13, 20, 555, 25, 3, 1, 53};
        int[] expected = {1, 2, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53, 555};

        assertArrayEquals(expected, countingSort.sortPositive(arr));
    }

    @Test
    @DisplayName("Testing CountingSort.sortNegative")
    public void testSortNegative() {
        int[] arr = {40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        int[] expected = {-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};

        assertArrayEquals(expected, countingSort.sortNegative(arr));
    }
}
