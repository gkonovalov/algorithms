package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * Tests for {@link CatalanNumbers}.
 * </p
 */
public class CatalanNumbersTest {

    private CatalanNumbers catalanNumbers;

    @BeforeEach
    public void setUp() {
        this.catalanNumbers = new CatalanNumbers();
    }

    @Test
    @DisplayName("Testing CatalanNumbers.catalanNumberDp")
    public void testCatalanNumberDp() {
        assertEquals(16796, catalanNumbers.catalanNumberDp(10));
    }

    @Test
    @DisplayName("Testing CatalanNumbers.catalanNumberRecursive")
    public void testCatalanNumberRecursive() {
        assertEquals(16796, catalanNumbers.catalanNumberRecursive(10));
    }
}
