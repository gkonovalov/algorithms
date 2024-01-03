package com.gkonovalov.algorithms.math.matrix.multiplication;

import com.gkonovalov.algorithms.math.matrix.multiplication.MatrixMultiplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * Tests for {@link MatrixMultiplication}.
 * </p
 */
public class MatrixMultiplicationTest {

    private MatrixMultiplication matrixMultiplication;

    @BeforeEach
    public void setUp() {
        this.matrixMultiplication = new MatrixMultiplication();
    }

    @Test
    @DisplayName("Testing MatrixMultiplication.multiply")
    public void testMultiply() {
        int[][] a = {
                {2, 4, 3},
                {6, 5, 2}
        };

        int[][] b = {
                {0, 1, 8},
                {2, 4, 9},
                {1, 6, 8}
        };

        int[][] expected = {
                {11, 36, 76},
                {12, 38, 109}
        };

        assertArrayEquals(expected, matrixMultiplication.multiply(a, b));
    }
}
