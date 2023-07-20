package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.EdgeList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 18/07/2023.
 * <p>
 * Tests for {@link BellmanFord}.
 * </p
 */
public class BellmanFordTest {
    private BellmanFord bellmanFord;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.bellmanFord = new BellmanFord(adjacencyList.getGraphWeightedDirected(true), 0);
    }

    @Test
    @DisplayName("Testing BellmanFord.distTo with AdjacencyList")
    public void testDistTo() {
        assertEquals(11, bellmanFord.distTo(6));
    }

    @Test
    @DisplayName("Testing BellmanFord.pathTo with AdjacencyList")
    public void testPathTo() {
         assertEquals(List.of(0, 2, 6), bellmanFord.pathTo(6));
    }
}
