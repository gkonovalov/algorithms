package com.gkonovalov.algorithms.graphs;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Tests for {@link Bipartite}.
 * </p
 */
public class BipartiteTest {

    private Bipartite bipartite;
    private AdjacencyList adjList;

    @BeforeEach
    public void setUp() {
        this.bipartite = new Bipartite();
        this.adjList = new AdjacencyList();
    }

    @Test
    @DisplayName("Testing Bipartite.isBipartiteColoring with AdjacencyList")
    public void testIsBipartiteColoring() {
        assertTrue(bipartite.isBipartiteColoring(adjList.getGraphBipartiteDirected(true)));
        assertFalse(bipartite.isBipartiteColoring(adjList.getGraphBipartiteDirected(false)));
    }

    @Test
    @DisplayName("Testing Bipartite.isBipartiteBFSColoring with AdjacencyList")
    public void testIsBipartiteBFSColoring() {
        assertTrue(bipartite.isBipartiteBFSColoring(adjList.getGraphBipartiteDirected(true)));
        assertFalse(bipartite.isBipartiteBFSColoring(adjList.getGraphBipartiteDirected(false)));
    }

    @Test
    @DisplayName("Testing Bipartite.isBipartiteIterativeDFSColoring with AdjacencyList")
    public void testIsBipartiteIterativeDFSColoring() {
        assertTrue(bipartite.isBipartiteIterativeDFSColoring(adjList.getGraphBipartiteDirected(true)));
        assertFalse(bipartite.isBipartiteIterativeDFSColoring(adjList.getGraphBipartiteDirected(false)));
    }
}
