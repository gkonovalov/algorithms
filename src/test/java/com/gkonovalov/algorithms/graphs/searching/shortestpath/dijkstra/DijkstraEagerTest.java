package com.gkonovalov.algorithms.graphs.searching.shortestpath.dijkstra;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 8/07/2023.
 * <p>
 * Tests for {@link DijkstraEager}.
 * </p
 */
public class DijkstraEagerTest {
    private DijkstraEager dijkstra;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.dijkstra = new DijkstraEager(adjacencyList.getGraphWeightedDirected(false), 0);
    }

    @Test
    @DisplayName("Testing DijkstraEager.distTo  with AdjacencyList")
    public void testDistTo() {
        assertEquals(95, dijkstra.distTo(6));
    }

    @Test
    @DisplayName("Testing DijkstraEager.pathTo with AdjacencyList")
    public void testPathTo() {
        assertEquals(List.of(0, 2, 3, 6), dijkstra.pathTo(6));
    }
}
