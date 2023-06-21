package com.gkonovalov.algorithms;

import com.gkonovalov.algorithms.graphs.CycleDetection;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyMatrix;
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
    private AdjacencyMatrix adjMatrix;

    @BeforeEach
    public void setUp() {
        this.cycleDetection = new CycleDetection();
        this.adjList = new AdjacencyList();
        this.adjMatrix = new AdjacencyMatrix();
    }

    @Test
    @DisplayName("Testing Cycle.hasCycleDFSUndirectedGraph with AdjacencyList")
    public void testHasCycleDFSUndirectedGraph() {
        assertTrue(cycleDetection.hasCycleDFSUndirectedGraph(adjList.getAdjacencyListUndirected(true)));
        assertFalse(cycleDetection.hasCycleDFSUndirectedGraph(adjList.getAdjacencyListUndirected(false)));
    }

    @Test
    @DisplayName("Testing Cycle.hasCycleDFSDirectedGraph with AdjacencyList")
    public void testHasCycleDFSDirectedGraph() {
        assertTrue(cycleDetection.hasCycleDFSDirectedGraph(adjList.getAdjacencyListDirected(true)));
        assertFalse(cycleDetection.hasCycleDFSDirectedGraph(adjList.getAdjacencyListDirected(false)));
    }

    @Test
    @DisplayName("Testing Cycle.hasCycleUndirectedGraphBFS with AdjacencyList")
    public void testHasCycleUndirectedGraphBFS() {
        assertTrue(cycleDetection.hasCycleUndirectedGraphBFS(adjList.getAdjacencyListUndirected(true)));
        assertFalse(cycleDetection.hasCycleUndirectedGraphBFS(adjList.getAdjacencyListUndirected(false)));
    }
}
