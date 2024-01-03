package com.gkonovalov.algorithms.math.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * Tests for {@link MatrixRotation}.
 * </p
 */
public class MatrixRotationTest {

    private MatrixRotation matrixRotation;

    @BeforeEach
    public void setUp() {
        this.matrixRotation = new MatrixRotation();
    }

    @Test
    @DisplayName("Testing MatrixRotation.clockWiseRotate")
    public void testClockWiseRotate() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3},
        };

        matrixRotation.clockWiseRotate(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Testing MatrixRotation.clockWiseRotate2")
    public void testClockWiseRotate2() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3},
        };

        matrixRotation.clockWiseRotate2(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Testing MatrixRotation.antiClockWiseRotate")
    public void testAntiClockWiseRotate() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int[][] expected = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7},
        };

        matrixRotation.antiClockWiseRotate(matrix);

        assertArrayEquals(expected, matrix);
    }
}
