package com.gkonovalov.algorithms.math.primenumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 24/08/2023.
 * <p>
 * Tests for {@link SieveOfEratosthenes}.
 * </p
 */
public class SieveOfEratosthenesTest {

    private SieveOfEratosthenes sieveOfEratosthenes;

    @BeforeEach
    public void setUp() {
        this.sieveOfEratosthenes = new SieveOfEratosthenes();
    }

    @Test
    @DisplayName("Testing SieveOfEratosthenes.findPrimeNumbers")
    public void testFindPrimeNumbers() {
        assertEquals(List.of(2, 3, 5, 7), sieveOfEratosthenes.findPrimeNumbers(10));
    }
}
