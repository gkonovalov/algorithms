package com.gkonovalov.algorithms.graphs.connectivity.unionfind.quickunion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link QuickUnionWeightedPathCompression}.
 * </p
 */
public class QuickUnionWeightedPathCompressionTest {

    private QuickUnionWeightedPathCompression qu;

    @BeforeEach
    public void setUp() {
        this.qu = new QuickUnionWeightedPathCompression(10);
    }

    @Test
    @DisplayName("Testing QuickUnionWeightedPathCompression connectivity")
    public void testIsConnected() {
        qu.union(1, 2);
        qu.union(1, 6);
        qu.union(2, 9);

        assertTrue(qu.isConnected(1, 9));
    }

    @Test
    @DisplayName("Testing QuickUnionWeightedPathCompression connected components count")
    public void testComponentsCount() {
        qu.union(3, 4);
        qu.union(2, 3);

        assertEquals(qu.componentsCount(), 8);
    }
}
