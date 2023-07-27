package com.gkonovalov.algorithms.arrays.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 27/07/2023.
 * <p>
 * Tests for {@link BucketSort}.
 * </p
 */
public class BucketSortTest {

    private BucketSort bucketSort;
    private double[] arr;

    @BeforeEach
    public void setUp() {
        this.bucketSort = new BucketSort();
        this.arr = new double[]{40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53, -200000};
    }

    @Test
    @DisplayName("Testing BucketSort.sort")
    public void testSort() {
        bucketSort.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]);
        }
    }
}
