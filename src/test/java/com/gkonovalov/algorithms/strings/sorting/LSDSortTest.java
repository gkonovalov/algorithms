package com.gkonovalov.algorithms.strings.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Georgiy Konovalov on 1/26/2024.
 * <p>
 * Tests for {@link LSDSort}.
 * </p
 */
public class LSDSortTest {

    private LSDSort lsd;

    @BeforeEach
    public void setUp() {
        this.lsd = new LSDSort();
    }

    @Test
    @DisplayName("Testing LSDSort.sort")
    public void testSort() {
        String[] arr = {"mat", "cat", "vat", "dog"};
        String[] expected = {"cat", "dog", "mat", "vat"};

        lsd.sort(arr, 3);

        assertArrayEquals(expected, arr);
    }
}
