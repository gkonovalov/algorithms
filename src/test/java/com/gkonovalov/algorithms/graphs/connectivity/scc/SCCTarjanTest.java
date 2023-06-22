package com.gkonovalov.algorithms.graphs.connectivity.scc;


import com.gkonovalov.algorithms.graphs.connectivity.scc.SCCTarjan;
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
 * Tests for {@link SCCTarjan}.
 * </p
 */
public class SCCTarjanTest {
    private SCCTarjan scc;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjList = new AdjacencyList();
        this.scc = new SCCTarjan(adjList.getAdjacencyListDirected(true));
    }

    @Test
    @DisplayName("Testing SCCTarjan.stronglyConnectedComponents")
    public void testStronglyConnectedComponents() {
        assertEquals(List.of(
                List.of(2),
                List.of(0, 1, 3),
                List.of(5),
                List.of(4)
        ), scc.stronglyConnectedComponents());
    }

    @Test
    @DisplayName("Testing SCCTarjan.isStronglyConnected")
    public void testIsStronglyConnected() {
        assertTrue(scc.isStronglyConnected(0, 1));
        assertFalse(scc.isStronglyConnected(0, 4));
    }
}
