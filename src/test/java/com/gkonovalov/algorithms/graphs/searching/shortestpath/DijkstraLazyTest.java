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
 * Tests for {@link DijkstraLazy}.
 * </p
 */
public class DijkstraLazyTest {
    private DijkstraLazy dijkstraLazy;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.dijkstraLazy = new DijkstraLazy(adjacencyList.getGraphWeightedDirected(), 0);
    }

    @Test
    @DisplayName("Testing DijkstraLazy.distTo  with AdjacencyList")
    public void testDistTo() {
        assertEquals(95, dijkstraLazy.distTo(6));
    }

    @Test
    @DisplayName("Testing DijkstraLazy.pathTo with AdjacencyList")
    public void testPathTo() {
        assertEquals(List.of(0, 2, 3, 6), dijkstraLazy.pathTo(6));
    }
}
