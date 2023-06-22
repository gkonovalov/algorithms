package com.gkonovalov.algorithms.graphs;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tests for {@link CycleDetection}.
 * </p
 */
public class CycleDetectionTest {

    private CycleDetection cycleDetection;
    private AdjacencyList adjList;

    @BeforeEach
    public void setUp() {
        this.cycleDetection = new CycleDetection();
        this.adjList = new AdjacencyList();
    }

    @Test
    @DisplayName("Testing Cycle.hasCycleDFSUndirectedGraph with AdjacencyList")
    public void testHasCycleDFSUndirectedGraph() {
        assertTrue(cycleDetection.hasCycleDFSUndirectedGraph(adjList.getGraphUndirected(true)));
        assertFalse(cycleDetection.hasCycleDFSUndirectedGraph(adjList.getGraphUndirected(false)));
    }

    @Test
    @DisplayName("Testing Cycle.hasCycleDFSDirectedGraph with AdjacencyList")
    public void testHasCycleDFSDirectedGraph() {
        assertTrue(cycleDetection.hasCycleDFSDirectedGraph(adjList.getGraphDirected(true)));
        assertFalse(cycleDetection.hasCycleDFSDirectedGraph(adjList.getGraphDirected(false)));
    }

    @Test
    @DisplayName("Testing Cycle.hasCycleUndirectedGraphBFS with AdjacencyList")
    public void testHasCycleUndirectedGraphBFS() {
        assertTrue(cycleDetection.hasCycleUndirectedGraphBFS(adjList.getGraphUndirected(true)));
        assertFalse(cycleDetection.hasCycleUndirectedGraphBFS(adjList.getGraphUndirected(false)));
    }
}
