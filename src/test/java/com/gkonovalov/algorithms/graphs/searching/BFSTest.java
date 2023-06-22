package com.gkonovalov.algorithms.graphs.searching;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Tests for {@link BFS}.
 * </p
 */
public class BFSTest {

    private BFS bfs;
    private AdjacencyList adjList;
    private AdjacencyMatrix adjMatrix;

    @BeforeEach
    public void setUp() {
        this.bfs = new BFS();
        this.adjList = new AdjacencyList();
        this.adjMatrix = new AdjacencyMatrix();
    }

    @Test
    @DisplayName("Testing BFS.search with AdjacencyList")
    public void testSearch() {
        assertTrue(bfs.search(adjList.getGraphUndirected(true), 0, 3));
        assertFalse(bfs.search(adjList.getGraphUndirected(true), 0, 4));
    }

    @Test
    @DisplayName("Testing BFS.search with AdjacencyMatrix")
    public void testSearch2() {
        assertTrue(bfs.search(adjMatrix.getGraphUndirected(), 0, 3));
        assertFalse(bfs.search(adjMatrix.getGraphUndirected(), 0, 4));
    }
}
