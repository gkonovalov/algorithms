package com.gkonovalov.algorithms.recursion.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Tests for {@link FibonacciNumbers}.
 * </p
 */
public class FibonacciNumberTest {

    private FibonacciNumbers fibonacciNumbers;

    @BeforeEach
    public void setUp() {
        this.fibonacciNumbers = new FibonacciNumbers();
    }

    @Test
    @DisplayName("Testing FibonacciNumbers.fibRecursiveTopDown")
    public void testFibRecursiveTopDown() {
        assertEquals(21, fibonacciNumbers.fibRecursiveTopDown(8));
    }

    @Test
    @DisplayName("Testing FibonacciNumbers.fibMemoizationTopDown")
    public void testFibMemoizationTopDown() {
        assertEquals(21, fibonacciNumbers.fibMemoizationTopDown(8));
    }

    @Test
    @DisplayName("Testing FibonacciNumbers.fibDPBottomUp")
    public void testFibDPBottomUp() {
        assertEquals(21, fibonacciNumbers.fibDPBottomUp(8));
    }

    @Test
    @DisplayName("Testing FibonacciNumbers.fibDPBottomUp2")
    public void testFibDPBottomUp2() {
        assertEquals(21, fibonacciNumbers.fibDPBottomUp2(8));
    }

    @Test
    @DisplayName("Testing FibonacciNumbers.fibIterativeBottomUp")
    public void testFibIterativeBottomUp() {
        assertEquals(21, fibonacciNumbers.fibIterativeBottomUp(8));
    }
}
