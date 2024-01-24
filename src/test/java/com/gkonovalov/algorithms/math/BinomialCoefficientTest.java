package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/24/2024.
 * <p>
 * Tests for {@link BinomialCoefficient}.
 * </p
 */
public class BinomialCoefficientTest {

    private BinomialCoefficient binomialCoefficient;

    @BeforeEach
    public void setUp() {
        this.binomialCoefficient = new BinomialCoefficient();
    }

    @Test
    @DisplayName("Testing BinomialCoefficient.bcDP")
    public void testBcDP() {
        assertEquals(10, binomialCoefficient.bcDP(5,2));
    }

    @Test
    @DisplayName("Testing BinomialCoefficient.bcRecursive")
    public void testBcRecursive() {
        assertEquals(10, binomialCoefficient.bcRecursive(5,2));
    }

    @Test
    @DisplayName("Testing BinomialCoefficient.bcIterative")
    public void testBcIterative() {
        assertEquals(10, binomialCoefficient.bcIterative(5,2));
    }

}
