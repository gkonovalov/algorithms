package com.gkonovalov.algorithms.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * Tests for {@link Kadane}.
 * </p
 */
public class KadaneTest {

    private Kadane kadane;
    private int[] arr;

    @BeforeEach
    public void setUp() {
        this.kadane = new Kadane();
        this.arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    @Test
    @DisplayName("Testing Kadane.maxSum")
    public void testSort() {
        assertEquals(6, kadane.maxSum(arr));
    }
}
