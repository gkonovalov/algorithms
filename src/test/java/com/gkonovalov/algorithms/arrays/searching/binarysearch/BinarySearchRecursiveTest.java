package com.gkonovalov.algorithms.arrays.searching.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link BinarySearchRecursive}.
 * </p
 */
public class BinarySearchRecursiveTest {

    private BinarySearchRecursive binarySearch;
    private int[] sortedArray;

    @BeforeEach
    public void setUp() {
        this.binarySearch = new BinarySearchRecursive();
        this.sortedArray = new int[]{-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};
    }

    @Test
    @DisplayName("Testing Binary Search Recursively")
    public void testSearchRecursively() {
        assertEquals(binarySearch.search(sortedArray, 13), 6);
        assertEquals(binarySearch.search(sortedArray, 9999), -1);
    }
}
