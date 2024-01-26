package com.gkonovalov.algorithms.arrays.selection.quickselect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 5/18/2023.
 * <p>
 * Tests for {@link QuickSelectPartitionHoare}.
 * </p
 */
public class QuickSelectPartitionHoareTest {

    private QuickSelectPartitionHoare quickSelect;

    @BeforeEach
    public void setUp() {
        this.quickSelect = new QuickSelectPartitionHoare();
    }

    @Test
    @DisplayName("Testing QuickSelectPartitionHoare.select")
    public void testSelect() {
        int[] arr = {40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};

        assertEquals(44, quickSelect.select(arr, 2, true));
        assertEquals(25, quickSelect.select(arr, 5, true));
        assertEquals(4, quickSelect.select(arr, 5, false));
        assertEquals(-2, quickSelect.select(arr, 2, false));
    }
}
