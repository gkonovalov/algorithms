package com.gkonovalov.algorithms.math.matrix.multiplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 1/4/2024.
 * <p>
 * Tests for {@link MatrixChainMultiplication}.
 * </p
 */
public class MatrixChainMultiplicationTest {

    private MatrixChainMultiplication mcm;

    @BeforeEach
    public void setUp() {
        this.mcm = new MatrixChainMultiplication();
    }

    @Test
    @DisplayName("Testing MatrixChainMultiplication.matrixChainOrderDP")
    public void testMatrixChainOrderDP() {
        int[] dimensions = {40, 20, 30, 10, 30};

        assertEquals(26000, mcm.matrixChainOrderDP(dimensions));
    }

    @Test
    @DisplayName("Testing MatrixChainMultiplication.matrixChainOrderRecursive")
    public void testMatrixChainOrderRecursive() {
        int[] dimensions = {40, 20, 30, 10, 30};

        assertEquals(26000, mcm.matrixChainOrderDP(dimensions));
    }

    @Test
    @DisplayName("Testing MatrixChainMultiplication.matrixChainOrderMemoization")
    public void testMatrixChainOrderMemoization() {
        int[] dimensions = {40, 20, 30, 10, 30};

        assertEquals(26000, mcm.matrixChainOrderMemoization(dimensions));
    }
}
