package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 20/07/2023.
 * <p>
 * Tests for {@link FloydWarshall}.
 * </p
 */
public class FloydWarshallTest {
    private FloydWarshall floydWarshall;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.floydWarshall = new FloydWarshall(adjacencyList.getGraphWeightedDirected(true));
    }

    @Test
    @DisplayName("Testing BellmanFord.distTo with AdjacencyList")
    public void testDistTo() {
        assertEquals(11, floydWarshall.dist(0, 6));
    }

    @Test
    @DisplayName("Testing BellmanFord.pathTo with AdjacencyList")
    public void testPathTo() {
         assertEquals(List.of(0, 2, 6), floydWarshall.pathTo(0, 6));
    }
}
