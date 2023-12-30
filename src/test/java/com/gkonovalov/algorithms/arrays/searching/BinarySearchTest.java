package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Testing BinarySearch.searchRecursive")
    public void testSearchRecursive() {
        assertEquals(binarySearch.searchRecursive(sortedArray, 13), 6);
        assertEquals(binarySearch.searchRecursive(sortedArray, 9999), -1);
    }

    @Test
    @DisplayName("Testing BinarySearch.searchIterative")
    public void testSearchIterative() {
        assertEquals(binarySearch.searchIterative(sortedArray, 13), 6);
        assertEquals(binarySearch.searchIterative(sortedArray, 9999), -1);
    }

    @Test
    @DisplayName("Testing BinarySearch.searchIterative2")
    public void testSearchIterative2() {
        assertEquals(binarySearch.searchIterative2(sortedArray, 13), 6);
        assertEquals(binarySearch.searchIterative2(sortedArray, 9999), -1);
    }
}
