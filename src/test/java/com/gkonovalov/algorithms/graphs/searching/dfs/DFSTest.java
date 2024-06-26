package com.gkonovalov.algorithms.graphs.searching.dfs;

import com.gkonovalov.algorithms.graphs.searching.dfs.DFS;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Testing DFS.searchRecursive with AdjacencyList")
    public void testSearchRecursive() {
        assertTrue(dfs.searchRecursive(adjList.getGraphUndirected(true), 0, 3));
        assertFalse(dfs.searchRecursive(adjList.getGraphUndirected(true), 0, 4));
    }

    @Test
    @DisplayName("Testing DFS.searchRecursive with AdjacencyMatrix")
    public void testSearchRecursive2() {
        assertTrue(dfs.searchRecursive(adjMatrix.getGraphUndirected(), 0, 3));
        assertFalse(dfs.searchRecursive(adjMatrix.getGraphUndirected(), 0, 4));
    }

    @Test
    @DisplayName("Testing DFS.searchPreorderIterative with AdjacencyList")
    public void testSearchPreorderIterative() {
        assertTrue(dfs.searchPreorderIterative(adjList.getGraphUndirected(true), 0, 3));
        assertFalse(dfs.searchPreorderIterative(adjList.getGraphUndirected(true), 0, 4));
    }
}
