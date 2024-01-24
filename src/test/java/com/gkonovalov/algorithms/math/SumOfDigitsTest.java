package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 24/1/2024.
 * <p>
 * Tests for {@link SumOfDigits}.
 * </p
 */
public class SumOfDigitsTest {

    private SumOfDigits sumOfDigits;

    @BeforeEach
    public void setUp() {
        this.sumOfDigits = new SumOfDigits();
    }

    @Test
    @DisplayName("Testing SumOfDigits.sum")
    public void testSum() {
        assertEquals(8, sumOfDigits.sum(233));
    }
}
