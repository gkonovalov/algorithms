package com.gkonovalov.algorithms.math.matrix;

import com.gkonovalov.algorithms.math.matrix.multiplication.MatrixExponentiation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * Tests for {@link MatrixInversion}.
 * </p
 */
public class MatrixInversionTest {

    private MatrixInversion mi;

    @BeforeEach
    public void setUp() {
        this.mi = new MatrixInversion();
    }

    @Test
    @DisplayName("Testing MatrixInversion.invert")
    public void testInvert() {
        double[][] a = {
                {2, 3},
                {2, 2}
        };

        double[][] expected = {
                {-1, 1.5},
                {1, -1}
        };

        assertArrayEquals(expected, mi.invert(a));
    }
}
