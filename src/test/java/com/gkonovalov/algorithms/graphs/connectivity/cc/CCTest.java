package com.gkonovalov.algorithms.graphs.connectivity.cc;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tests for {@link CC}.
 * </p
 */
public class CCTest {
    private CC cc;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjList = new AdjacencyList();
        this.cc = new CC(adjList.getGraphDirected(true));
    }

    @Test
    @DisplayName("Testing CC.connectedComponentsCount")
    public void testStronglyConnectedComponentsCount() {
        assertEquals(2, cc.connectedComponentsCount());
    }

    @Test
    @DisplayName("Testing CC.connectedComponents")
    public void testStronglyConnectedComponents() {
        assertEquals(List.of(
                List.of(0, 1,2, 3),
                List.of(4,5)
        ), cc.connectedComponents());
    }

    @Test
    @DisplayName("Testing CC.isStronglyConnected")
    public void testIsStronglyConnected() {
        assertTrue(cc.isConnected(0, 1));
        assertFalse(cc.isConnected(4, 0));
    }
}
