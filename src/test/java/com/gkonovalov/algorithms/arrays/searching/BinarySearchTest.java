package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link BinarySearch}.
 * </p
 */
public class BinarySearchTest {

    private BinarySearch binarySearch;
    private int[] sortedArray;

    @BeforeEach
    public void setUp() {
        this.binarySearch = new BinarySearch();
        this.sortedArray = new int[]{-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};
    }

    @Test
    @DisplayName("Testing Binary Search Iteratively")
    public void testSearchIteratively() {
        assertEquals(binarySearch.searchIteratively(sortedArray, 13), 6);
        assertEquals(binarySearch.searchIteratively(sortedArray, 9999), -1);
    }

    @Test
    @DisplayName("Testing Binary Search Iteratively2")
    public void testSearchIteratively2() {
        assertEquals(binarySearch.searchIteratively2(sortedArray, 13), 6);
        assertEquals(binarySearch.searchIteratively2(sortedArray, 9999), -1);
    }

    @Test
    @DisplayName("Testing Binary Search Recursively")
    public void testSearchRecursively() {
        assertEquals(binarySearch.searchRecursively(sortedArray, 13), 6);
        assertEquals(binarySearch.searchRecursively(sortedArray, 9999), -1);
    }
}
