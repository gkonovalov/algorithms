package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 18/07/2023.
 * <p>
 * Tests for {@link AStar}.
 * </p
 */
public class AStarTest {
    private AStar aStar;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.aStar = new AStar(adjacencyList.getGraphWeightedDirected(true), 0, 6);
    }

    @Test
    @DisplayName("Testing AStar.dist with AdjacencyList")
    public void testDistTo() {
        assertEquals(11, aStar.dist());
    }

    @Test
    @DisplayName("Testing AStar.path with AdjacencyList")
    public void testPathTo() {
         assertEquals(List.of(0, 2, 6), aStar.path());
    }
}
