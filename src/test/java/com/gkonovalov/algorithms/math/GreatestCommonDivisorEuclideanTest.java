package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * Tests for {@link GreatestCommonDivisorEuclidean}.
 * </p
 */
public class GreatestCommonDivisorEuclideanTest {

    private GreatestCommonDivisorEuclidean gcd;

    @BeforeEach
    public void setUp() {
        this.gcd = new GreatestCommonDivisorEuclidean();
    }

    @Test
    @DisplayName("Testing GreatestCommonDivisorEuclidean.gcdRecursive")
    public void testGcdRecursive() {
        assertEquals(3, gcd.gcdRecursive(27, 6));
    }

    @Test
    @DisplayName("Testing GreatestCommonDivisorEuclidean.gcdIterative")
    public void testGcdIterative() {
        assertEquals(3, gcd.gcdIterative(27, 6));
    }

    @Test
    @DisplayName("Testing GreatestCommonDivisorEuclidean.gcdExtended")
    public void testGcdExtended() {
        assertEquals(3, gcd.gcdExtended(27, 6));
    }
}
