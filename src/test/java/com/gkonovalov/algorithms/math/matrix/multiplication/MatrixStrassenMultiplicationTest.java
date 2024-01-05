package com.gkonovalov.algorithms.math.matrix.multiplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * Created by Georgiy Konovalov on 1/4/2024.
 * <p>
 * Tests for {@link MatrixStrassenMultiplication}.
 * </p
 */
public class MatrixStrassenMultiplicationTest {

    private MatrixStrassenMultiplication msm;

    @BeforeEach
    public void setUp() {
        this.msm = new MatrixStrassenMultiplication();
    }

    @Test
    @DisplayName("Testing MatrixStrassenMultiplication.multiply")
    public void testMultiply() {
        int[][] a = {
                {2, 4},
                {6, 5}
        };

        int[][] b = {
                {0, 1},
                {2, 4}
        };

        int[][] expected = {
                {8, 18},
                {10, 26}
        };

        assertArrayEquals(expected, msm.multiply(a, b));
    }
}
