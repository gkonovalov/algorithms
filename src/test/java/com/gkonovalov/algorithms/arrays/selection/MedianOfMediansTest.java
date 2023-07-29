package com.gkonovalov.algorithms.arrays.selection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 28/07/2023.
 * <p>
 * Tests for {@link MedianOfMedians}.
 * </p
 */
public class MedianOfMediansTest {

    private MedianOfMedians medianOfMedians;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.medianOfMedians = new MedianOfMedians();
        this.arr = new int[]{40, -2, 4, 44, 5, 5, 42, 13, 20, -555, 25, 3, -1, 53};
    }

    @Test
    @DisplayName("Testing MedianOfMedians.findKElement")
    public void testFindKElement() {
        assertEquals(-555, medianOfMedians.findKElement(arr, 1, false));
        assertEquals(53, medianOfMedians.findKElement(arr, 1, true));
        assertEquals(44, medianOfMedians.findKElement(arr, 2, true));
        assertEquals(25, medianOfMedians.findKElement(arr, 5, true));
        assertEquals(4, medianOfMedians.findKElement(arr, 5, false));
        assertEquals(-2, medianOfMedians.findKElement(arr, 2, false));
    }
}
