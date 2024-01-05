package com.gkonovalov.algorithms.math.matrix.multiplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * Created by Georgiy Konovalov on 1/4/2024.
 * <p>
 * Tests for {@link SparseMatrixMultiplication}.
 * </p
 */
public class SparseMatrixMultiplicationTest {

    private SparseMatrixMultiplication smm;

    @BeforeEach
    public void setUp() {
        this.smm = new SparseMatrixMultiplication();
    }

    @Test
    @DisplayName("Testing SparseMatrixMultiplication.multiply")
    public void testMultiply() {
        double[][] a = {
                {1, 0, 0},
                {0, 2, 0},
                {0, 0, 3}
        };

        double[][] b = {
                {4, 0, 0},
                {0, 5, 0},
                {0, 0, 6}
        };

        double[][] expected = {
                {4, 0, 0},
                {0, 10, 0},
                {0, 0, 18}
        };

        assertArrayEquals(expected, smm.multiply(a, b));
    }

    @Test
    @DisplayName("Testing SparseMatrixMultiplication.multiply2")
    public void testMultiply2() {
        double[][] a = {
                {1, 0, 0},
                {0, 2, 0},
                {0, 0, 3}
        };

        double[][] b = {
                {4, 0, 0},
                {0, 5, 0},
                {0, 0, 0}
        };

        double[][] expected = {
                {4, 0, 0},
                {0, 10, 0},
                {0, 0, 0}
        };

        assertArrayEquals(expected, smm.multiply2(a, b));
    }
}
