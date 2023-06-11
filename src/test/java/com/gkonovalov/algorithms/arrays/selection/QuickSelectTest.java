package com.gkonovalov.algorithms.arrays.selection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 18/05/2023.
 * <p>
 * Tests for {@link QuickSelect}.
 * </p
 */
public class QuickSelectTest {

    private QuickSelect quickSelect;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.quickSelect = new QuickSelect();
        this.arr = new int[]{40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing QuickSelect.randomizedSelection")
    public void testRandomizedSelection() {
        assertEquals(44, quickSelect.randomizedSelection(arr, 2, true));
        assertEquals(-2, quickSelect.randomizedSelection(arr, 2, false));
    }

    @Test
    @DisplayName("Testing QuickSelect.fixedSelection")
    public void testFixedSelection() {
        assertEquals(44, quickSelect.fixedSelection(arr, 2, true));
        assertEquals(-2, quickSelect.fixedSelection(arr, 2, false));
    }
}
