package com.gkonovalov.algorithms.math.primenumbers.factorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/5/2023.
 * <p>
 * Tests for {@link TrialDivisionPrimeFactorization}.
 * </p
 */
public class TrialDivisionPrimeFactorizationTest {

    private TrialDivisionPrimeFactorization primeFactorization;

    @BeforeEach
    public void setUp() {
        this.primeFactorization = new TrialDivisionPrimeFactorization();
    }

    @Test
    @DisplayName("Testing TrialDivisionPrimeFactorization.factorize")
    public void testFactorize() {
        assertEquals(List.of(5, 7), primeFactorization.factorize(35));
    }
}
