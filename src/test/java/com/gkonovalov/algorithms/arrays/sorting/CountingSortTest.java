package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link CountingSort}.
 * </p
 */
public class CountingSortTest {

    private CountingSort countingSort;
    private int[] arrNegative;
    private int[] arrPositive;

    @BeforeEach
    public void setUp() {
        this.countingSort = new CountingSort();
        this.arrNegative = new int[]{40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};
        this.arrPositive = new int[]{40, 2, 4, 44, 5, 42, 13, 20, 555, 25, 3, 1, 53};
    }

    @Test
    @DisplayName("Testing CountingSort.sortPositive")
    public void testSortPositive() {
        arrPositive = countingSort.sortPositive(arrPositive);

        for (int i = 1; i < arrPositive.length; i++) {
            assertTrue(arrPositive[i - 1] < arrPositive[i]);
        }
    }

    @Test
    @DisplayName("Testing sortPositive.sortNegative")
    public void testSortNegative() {
        arrNegative = countingSort.sortNegative(arrNegative);

        for (int i = 1; i < arrNegative.length; i++) {
            assertTrue(arrNegative[i - 1] < arrNegative[i]);
        }
    }
}
