package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link LinearSearch}.
 * </p
 */
public class LinearSearchTest {

    private LinearSearch linearSearch;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.linearSearch = new LinearSearch();
        this.arr = new int[]{40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing Linear Search Iteratively")
    public void testSearchIteratively() {
        assertEquals(linearSearch.searchIteratively(arr, 13), 6);
        assertEquals(linearSearch.searchIteratively(arr, 9999), -1);
    }
}
