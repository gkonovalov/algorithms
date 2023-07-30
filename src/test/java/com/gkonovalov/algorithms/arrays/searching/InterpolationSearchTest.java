package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 30/07/2023.
 * <p>
 * Tests for {@link InterpolationSearch}.
 * </p
 */
public class InterpolationSearchTest {

    private InterpolationSearch interpolationSearch;
    private int[] sortedArray;

    @BeforeEach
    public void setUp() {
        this.interpolationSearch = new InterpolationSearch();
        this.sortedArray = new int[]{-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};
    }

    @Test
    @DisplayName("Testing InterpolationSearch.search")
    public void testSearchIteratively() {
        assertEquals(interpolationSearch.search(sortedArray, 13), 6);
        assertEquals(interpolationSearch.search(sortedArray, 9999), -1);
    }
}
