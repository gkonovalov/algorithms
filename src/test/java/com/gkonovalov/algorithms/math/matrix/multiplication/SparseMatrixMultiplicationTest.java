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

    private SparseMatrixMultiplication sparseMatrixMultiplication;

    @BeforeEach
    public void setUp() {
        this.sparseMatrixMultiplication = new SparseMatrixMultiplication();
    }

    @Test
    @DisplayName("Testing SparseMatrixMultiplication.multiply")
    public void testMultiply() {
        int[][] a = {
                {1, 0, 0},
                {0, 2, 0},
                {0, 0, 3}
        };

        int[][] b = {
                {4, 0, 0},
                {0, 5, 0},
                {0, 0, 6}
        };

        int[][] expected = {
                {4, 0, 0},
                {0, 10, 0},
                {0, 0, 18}
        };

        assertArrayEquals(expected, sparseMatrixMultiplication.multiply(a, b));
    }
}
