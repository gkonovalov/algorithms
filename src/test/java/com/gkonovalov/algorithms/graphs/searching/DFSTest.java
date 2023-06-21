package com.gkonovalov.algorithms.graphs.searching;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Tests for {@link DFS}.
 * </p
 */
public class DFSTest {

    private DFS dfs;
    private AdjacencyList adjList;
    private AdjacencyMatrix adjMatrix;

    @BeforeEach
    public void setUp() {
        this.dfs = new DFS();
        this.adjList = new AdjacencyList();
        this.adjMatrix = new AdjacencyMatrix();
    }

    @Test
    @DisplayName("Testing DFS.pathRecursive with AdjacencyList")
    public void testPathRecursive() {
        List<Integer> noPath = dfs.pathRecursive(adjList.getAdjacencyListUndirected(true), 0, 5);
        List<Integer> hasPath = dfs.pathRecursive(adjList.getAdjacencyListUndirected(true), 0, 3);

        assertIterableEquals(List.of(), noPath);
        assertIterableEquals(List.of(0, 1, 3), hasPath);
    }

    @Test
    @DisplayName("Testing DFS.searchRecursive with AdjacencyList")
    public void testSearchRecursive() {
        assertTrue(dfs.searchRecursive(adjList.getAdjacencyListUndirected(true), 0, 3));
        assertFalse(dfs.searchRecursive(adjList.getAdjacencyListUndirected(true), 0, 4));
    }

    @Test
    @DisplayName("Testing DFS.searchRecursive with AdjacencyMatrix")
    public void testSearchRecursive2() {
        assertTrue(dfs.searchRecursive(adjMatrix.getAdjacencyMatrixUndirected(), 0, 3));
        assertFalse(dfs.searchRecursive(adjMatrix.getAdjacencyMatrixUndirected(), 0, 4));
    }

    @Test
    @DisplayName("Testing DFS.searchPreorderIterative with AdjacencyList")
    public void testSearchPreorderIterative() {
        assertTrue(dfs.searchPreorderIterative(adjList.getAdjacencyListUndirected(true), 0, 3));
        assertFalse(dfs.searchPreorderIterative(adjList.getAdjacencyListUndirected(true), 0, 4));
    }
}
