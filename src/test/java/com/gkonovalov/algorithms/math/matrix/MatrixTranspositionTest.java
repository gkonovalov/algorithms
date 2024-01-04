package com.gkonovalov.algorithms.math.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * Tests for {@link MatrixTransposition}.
 * </p
 */
public class MatrixTranspositionTest {

    private MatrixTransposition matrixTransposition;

    @BeforeEach
    public void setUp() {
        this.matrixTransposition = new MatrixTransposition();
    }

    @Test
    @DisplayName("Testing MatrixTransposition.transpose")
    public void testTranspose() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9},
        };


        assertArrayEquals(expected, matrixTransposition.transpose(matrix));
    }
}
