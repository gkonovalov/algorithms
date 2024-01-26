package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link BubbleSort}.
 * </p
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    public void setUp() {
        this.bubbleSort = new BubbleSort();
    }

    @Test
    @DisplayName("Testing Bubble Sort")
    public void testSort() {
        int[] arr = {40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        int[] expected = {-555, -2, -1, 3, 4, 5, 5, 13, 20, 25, 40, 42, 44, 53};

        bubbleSort.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
