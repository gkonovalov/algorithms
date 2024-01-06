package com.gkonovalov.algorithms.math.primenumbers.primalitytest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by Georgiy Konovalov on 1/5/2023.
 * <p>
 * Tests for {@link MillerRabinPrimalityTest}.
 * </p
 */
public class MillerRabinPrimalityTestTest {

    private MillerRabinPrimalityTest primalityTest;

    @BeforeEach
    public void setUp() {
        this.primalityTest = new MillerRabinPrimalityTest();
    }

    @Test
    @DisplayName("Testing MillerRabinPrimalityTest.isPrimeNumber")
    public void testIsPrimeNumber() {
        assertFalse(primalityTest.isPrimeNumber(123, 40));
    }
}
