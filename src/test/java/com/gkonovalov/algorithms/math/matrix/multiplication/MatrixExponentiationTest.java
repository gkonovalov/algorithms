package com.gkonovalov.algorithms.math.matrix.multiplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * Tests for {@link MatrixExponentiation}.
 * </p
 */
public class MatrixExponentiationTest {

    private MatrixExponentiation me;

    @BeforeEach
    public void setUp() {
        this.me = new MatrixExponentiation();
    }

    @Test
    @DisplayName("Testing MatrixExponentiation.power")
    public void testPower() {
        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {37, 54},
                {81, 118}
        };

        assertArrayEquals(expected, me.power(a, 3));
    }

    @Test
    @DisplayName("Testing MatrixExponentiation.powerBySquaring")
    public void testPowerBySquaring() {
        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {37, 54},
                {81, 118}
        };


        assertArrayEquals(expected, me.powerBySquaring(a, 3));
    }
}
