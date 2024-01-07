package com.gkonovalov.algorithms.graphs.sorting;

import com.gkonovalov.algorithms.graphs.sorting.topological.TopologicalSortTarjan;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tests for {@link TopologicalSortTarjan}.
 * </p
 */
public class TopologicalSortTarjanTest {

    private TopologicalSortTarjan topologicalSort;
    private AdjacencyList adjList;

    @BeforeEach
    public void setUp() {
        this.topologicalSort = new TopologicalSortTarjan();
        this.adjList = new AdjacencyList();
    }

    @Test
    @DisplayName("Testing TopologicalSortTarjan.topologicalSort")
    public void testTopologicalSort() {
        int[] actualOrder = topologicalSort.topologicalSort(adjList.getGraphDirected(false));
        int[] expectedOrder = new int[]{4, 5, 0, 2, 1, 3};

        assertArrayEquals(expectedOrder, actualOrder);
        assertNull(topologicalSort.topologicalSort(adjList.getGraphDirected(true)));
    }
}
