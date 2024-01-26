package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 5/12/2023.
 * <p>
 * Tests for {@link LinearSearch}.
 * </p
 */
public class LinearSearchTest {

    private LinearSearch linearSearch;

    @BeforeEach
    public void setUp() {
        this.linearSearch = new LinearSearch();
    }

    @Test
    @DisplayName("Testing LinearSearch.search")
    public void testSearchIteratively() {
        int[] arr = {40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};

        assertEquals(linearSearch.search(arr, 13), 6);
        assertEquals(linearSearch.search(arr, 9999), -1);
    }
}
