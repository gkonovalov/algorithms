package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * Tests for {@link PowerOfTwo}.
 * </p
 */
public class PowerOfTwoTest {

    private PowerOfTwo powerOfTwo;

    @BeforeEach
    public void setUp() {
        this.powerOfTwo = new PowerOfTwo();
    }

    @Test
    @DisplayName("Testing PowerOfTwo.isPowerOfTwo")
    public void testIsPowerOfTwo() {
        assertTrue(powerOfTwo.isPowerOfTwo(8));
        assertFalse(powerOfTwo.isPowerOfTwo(7));
    }

    @Test
    @DisplayName("Testing PowerOfTwo.isPowerOfTwo2")
    public void testIsPowerOfTwo2() {
        assertTrue(powerOfTwo.isPowerOfTwo2(8));
        assertFalse(powerOfTwo.isPowerOfTwo2(7));
    }
}
