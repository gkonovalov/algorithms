package com.gkonovalov.algorithms.math.primenumbers.factorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/5/2024.
 * <p>
 * Tests for {@link WheelPrimeFactorization}.
 * </p
 */
public class WheelPrimeFactorizationTest {

    private WheelPrimeFactorization primeFactorization;

    @BeforeEach
    public void setUp() {
        this.primeFactorization = new WheelPrimeFactorization();
    }

    @Test
    @DisplayName("Testing WheelPrimeFactorization.factorize")
    public void testFactorize() {
        assertEquals(List.of(5, 7), primeFactorization.factorize(35));
    }
}
