package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Tests for {@link Factorial}.
 * </p
 */
public class FactorialTest {

    private Factorial factorial;

    @BeforeEach
    public void setUp() {
        this.factorial = new Factorial();
    }

    @Test
    @DisplayName("Testing Factorial.recursiveFactorial")
    public void testRecursiveFactorial() {
        assertEquals(120, factorial.recursiveFactorial(5));
    }

    @Test
    @DisplayName("Testing Factorial.iterativeFactorialBig")
    public void testIterativeFactorialBig() {
        String expectedResult = "93326215443944152681699238856266700490715968264381621468592963895217599993229915" +
                "608941463976156518286253697920827223758251185210916864000000000000000000000000";

        assertEquals(expectedResult, factorial.iterativeFactorialBig(100));
    }

    @Test
    @DisplayName("Testing Factorial.recursiveFactorialBig")
    public void testRecursiveFactorialBig() {
        String expectedResult = "93326215443944152681699238856266700490715968264381621468592963895217599993229915" +
                "608941463976156518286253697920827223758251185210916864000000000000000000000000";

        assertEquals(expectedResult, factorial.recursiveFactorialBig(100).toString());
    }
}
