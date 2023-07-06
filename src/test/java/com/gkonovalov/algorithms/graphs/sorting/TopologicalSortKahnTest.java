package com.gkonovalov.algorithms.graphs.sorting;

import com.gkonovalov.algorithms.graphs.sorting.topological.TopologicalSortKahn;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tests for {@link TopologicalSortKahn}.
 * </p
 */
public class TopologicalSortKahnTest {

    private TopologicalSortKahn topologicalSort;
    private AdjacencyList adjList;

    @BeforeEach
    public void setUp() {
        this.topologicalSort = new TopologicalSortKahn();
        this.adjList = new AdjacencyList();
    }

    @Test
    @DisplayName("Testing TopologicalSortKahn.topologicalSort")
    public void testTopologicalSort() {
        int[] actualOrder = topologicalSort.topologicalSort(adjList.getGraphDirected(false));
        int[] expectedOrder = new int[]{0, 4, 1, 2, 5, 3};

        assertArrayEquals(expectedOrder, actualOrder);
        assertNull(topologicalSort.topologicalSort(adjList.getGraphDirected(true)));
    }

}
