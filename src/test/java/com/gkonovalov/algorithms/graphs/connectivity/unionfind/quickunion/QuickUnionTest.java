package com.gkonovalov.algorithms.graphs.connectivity.unionfind.quickunion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link QuickUnion}.
 * </p
 */
public class QuickUnionTest {

    private QuickUnion quickUnion;

    @BeforeEach
    public void setUp() {
        this.quickUnion = new QuickUnion(10);
    }

    @Test
    @DisplayName("Testing QuickUnion connectivity")
    public void testIsConnected() {
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);

        assertTrue(quickUnion.isConnected(8, 9));
        assertFalse(quickUnion.isConnected(5, 4));
        assertFalse(quickUnion.isConnected(1, 3));
    }

    @Test
    @DisplayName("Testing QuickUnion connected components count")
    public void testComponentsCount() {
        quickUnion.union(3, 4);
        quickUnion.union(2, 3);

        assertEquals(quickUnion.componentsCount(), 8);
    }
}
