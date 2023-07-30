package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 30/07/2023.
 * <p>
 * Tests for {@link ExponentialSearch}.
 * </p
 */
public class ExponentialSearchTest {

    private ExponentialSearch exponentialSearch;
    private int[] sortedArray;

    @BeforeEach
    public void setUp() {
        this.exponentialSearch = new ExponentialSearch();
        this.sortedArray = new int[]{-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};
    }

    @Test
    @DisplayName("Testing ExponentialSearch.search")
    public void testSearch() {
        assertEquals(exponentialSearch.search(sortedArray, 13), 6);
        assertEquals(exponentialSearch.search(sortedArray, 9999), -1);
    }
}
