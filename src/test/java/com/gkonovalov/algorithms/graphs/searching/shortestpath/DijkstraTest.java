package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 8/07/2023.
 * <p>
 * Tests for {@link Dijkstra}.
 * </p
 */
public class DijkstraTest {
    private Dijkstra dijkstra;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.dijkstra = new Dijkstra(adjacencyList.getGraphWeightedDirected(false), 0);
    }

    @Test
    @DisplayName("Testing Dijkstra.distTo  with AdjacencyList")
    public void testDistTo() {
        assertEquals(95, dijkstra.distTo(6));
    }

    @Test
    @DisplayName("Testing Dijkstra.pathTo with AdjacencyList")
    public void testPathTo() {
        assertEquals(List.of(0, 2, 3, 6), dijkstra.pathTo(6));
    }
}
