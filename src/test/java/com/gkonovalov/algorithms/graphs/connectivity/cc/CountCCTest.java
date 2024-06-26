package com.gkonovalov.algorithms.graphs.connectivity.cc;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Tests for {@link CountCC}.
 * </p
 */
public class CountCCTest {

    private CountCC cc;
    private AdjacencyList adjList;
    private AdjacencyMatrix adjMatrix;

    @BeforeEach
    public void setUp() {
        this.cc = new CountCC();
        this.adjList = new AdjacencyList();
        this.adjMatrix = new AdjacencyMatrix();
    }

    @Test
    @DisplayName("Testing CC.countConnectedComponentsDfs with AdjacencyList")
    public void testCountConnectedComponentsDfs() {
        assertEquals(cc.countConnectedComponentsDfs(adjList.getGraphUndirected(true)), 2);
    }

    @Test
    @DisplayName("Testing CC.countConnectedComponentsDfs with AdjacencyMatrix")
    public void testCountConnectedComponentsDfs2() {
        assertEquals(cc.countConnectedComponentsDfs(adjMatrix.getGraphUndirected()), 2);
    }

    @Test
    @DisplayName("Testing CC.countConnectedComponentsBfs with AdjacencyList")
    public void testCountConnectedComponentsBFS() {
        assertEquals(cc.countConnectedComponentsBfs(adjList.getGraphUndirected(true)), 2);
    }

    @Test
    @DisplayName("Testing CC.countConnectedComponentsBfs with AdjacencyMatrix")
    public void testCountConnectedComponentsBFS2() {
        assertEquals(cc.countConnectedComponentsBfs(adjMatrix.getGraphUndirected()), 2);
    }
}
