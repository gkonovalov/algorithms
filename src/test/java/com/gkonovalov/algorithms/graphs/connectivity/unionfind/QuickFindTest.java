package com.gkonovalov.algorithms.graphs.connectivity.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Tests for {@link QuickFind}.
 * </p
 */
public class QuickFindTest {

    private QuickFind quickFind;

    @BeforeEach
    public void setUp() {
        this.quickFind = new QuickFind(10);
    }

    @Test
    @DisplayName("Testing QuickFind connectivity")
    public void testIsConnected() {
        quickFind.union(3, 4);
        quickFind.union(2, 3);

        assertTrue(quickFind.isConnected(2, 4));
        assertFalse(quickFind.isConnected(1, 3));
    }

    @Test
    @DisplayName("Testing QuickFind connected components count")
    public void testComponentsCount() {
        quickFind.union(3, 4);
        quickFind.union(2, 3);

        assertEquals(quickFind.componentsCount(), 8);
    }
}
