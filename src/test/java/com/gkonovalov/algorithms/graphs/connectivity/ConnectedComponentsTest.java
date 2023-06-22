package com.gkonovalov.algorithms.graphs.connectivity;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Tests for {@link ConnectedComponents}.
 * </p
 */
public class ConnectedComponentsTest {

    private ConnectedComponents cc;
    private AdjacencyList adjList;
    private AdjacencyMatrix adjMatrix;

    @BeforeEach
    public void setUp() {
        this.cc = new ConnectedComponents();
        this.adjList = new AdjacencyList();
        this.adjMatrix = new AdjacencyMatrix();
    }

    @Test
    @DisplayName("Testing ConnectedComponents.countConnectedComponentsDfs with AdjacencyList")
    public void testCountConnectedComponentsDfs() {
        assertEquals(cc.countConnectedComponentsDfs(adjList.getAdjacencyListUndirected(true)), 2);
    }

    @Test
    @DisplayName("Testing ConnectedComponents.countConnectedComponentsBfs with AdjacencyMatrix")
    public void testCountConnectedComponentsBFS() {
        assertEquals(cc.countConnectedComponentsBfs(adjMatrix.getAdjacencyMatrixUndirected()), 2);
    }

    @Test
    @DisplayName("Testing ConnectedComponents.countConnectedComponentsDfs with AdjacencyMatrix")
    public void testCountConnectedComponentsDfs2() {
        assertEquals(cc.countConnectedComponentsDfs(adjMatrix.getAdjacencyMatrixUndirected()), 2);
    }
}
