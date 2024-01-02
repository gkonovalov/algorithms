package com.gkonovalov.algorithms.graphs.connectivity.unionfind.quickunion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link QuickUnionWeighted}.
 * </p
 */
public class QuickUnionWeightedTest {

    private QuickUnionWeighted quickUnionWeighted;

    @BeforeEach
    public void setUp() {
        this.quickUnionWeighted = new QuickUnionWeighted(10);
    }

    @Test
    @DisplayName("Testing QuickUnionWeighted connectivity")
    public void testIsConnected() {
        quickUnionWeighted.union(1, 2);
        quickUnionWeighted.union(1, 6);
        quickUnionWeighted.union(2, 9);

        assertTrue(quickUnionWeighted.isConnected(1, 9));
    }

    @Test
    @DisplayName("Testing QuickUnionWeighted connected components count")
    public void testComponentsCount() {
        quickUnionWeighted.union(3, 4);
        quickUnionWeighted.union(2, 3);

        assertEquals(quickUnionWeighted.componentsCount(), 8);
    }

    @Test
    @DisplayName("Testing QuickUnionWeighted find larger element")
    public void testFindLargerElement() {
        quickUnionWeighted.union(3, 4);
        quickUnionWeighted.union(2, 3);

        assertEquals(quickUnionWeighted.findLargerElement(2), 4);
    }
}
