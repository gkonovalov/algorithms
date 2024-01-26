package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 7/27/2023.
 * <p>
 * Tests for {@link TernarySearch}.
 * </p
 */
public class TernarySearchTest {

    private TernarySearch ternarySearch;

    @BeforeEach
    public void setUp() {
        this.ternarySearch = new TernarySearch();
    }

    @Test
    @DisplayName("Testing TernarySearch.search")
    public void testSearch() {
        int[] arr = {-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};

        assertEquals(ternarySearch.search(arr, 13), 6);
        assertEquals(ternarySearch.search(arr, 9999), -1);
    }
}
