package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * Tests for {@link FastExponentiation}.
 * </p
 */
public class FastExponentiationTest {

    private FastExponentiation fastPow;

    @BeforeEach
    public void setUp() {
        this.fastPow = new FastExponentiation();
    }

    @Test
    @DisplayName("Testing FastExponentiation.powerRecursive")
    public void testPowerRecursive() {
        assertEquals(16, fastPow.powerRecursive(2, 4));
    }

    @Test
    @DisplayName("Testing FastExponentiation.powerIterative")
    public void testPowerIterative() {
        assertEquals(16, fastPow.powerIterative(2, 4));
    }
}
