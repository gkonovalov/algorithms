package com.gkonovalov.algorithms.arrays.searching.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link BinarySearchIterative}.
 * </p
 */
public class BinarySearchIterativeTest {

    private BinarySearchIterative binarySearch;
    private int[] sortedArray;

    @BeforeEach
    public void setUp() {
        this.binarySearch = new BinarySearchIterative();
        this.sortedArray = new int[]{-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};
    }

    @Test
    @DisplayName("Testing Binary Search Iteratively")
    public void testSearch() {
        assertEquals(binarySearch.search(sortedArray, 13), 6);
        assertEquals(binarySearch.search(sortedArray, 9999), -1);
    }

    @Test
    @DisplayName("Testing Binary Search Iteratively2")
    public void testSearch2() {
        assertEquals(binarySearch.search2(sortedArray, 13), 6);
        assertEquals(binarySearch.search2(sortedArray, 9999), -1);
    }
}
