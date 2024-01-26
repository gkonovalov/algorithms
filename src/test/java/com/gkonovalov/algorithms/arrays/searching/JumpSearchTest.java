package com.gkonovalov.algorithms.arrays.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 7/27/2023.
 * <p>
 * Tests for {@link JumpSearch}.
 * </p
 */
public class JumpSearchTest {

    private JumpSearch jumpSearch;

    @BeforeEach
    public void setUp() {
        this.jumpSearch = new JumpSearch();
    }

    @Test
    @DisplayName("Testing JumpSearch.search")
    public void testSearchIteratively() {
        int[] sortedArray = {-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};

        assertEquals(jumpSearch.search(sortedArray, 13), 6);
        assertEquals(jumpSearch.search(sortedArray, 9999), -1);
    }
}
