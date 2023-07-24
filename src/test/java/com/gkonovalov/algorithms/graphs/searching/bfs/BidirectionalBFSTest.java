package com.gkonovalov.algorithms.graphs.searching.bfs;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 23/07/2023.
 * <p>
 * Tests for {@link BidirectionalBFS}.
 * </p
 */
public class BidirectionalBFSTest {

    private BidirectionalBFS bidirectionalBFS;

    @BeforeEach
    public void setUp() {
        this.bidirectionalBFS = new BidirectionalBFS();
    }

    @Test
    @DisplayName("Testing BidirectionalBFS.search")
    public void testSearch() {
        AdjacencyList adjList = new AdjacencyList();

        assertTrue(bidirectionalBFS.search(adjList.getGraphUndirected(false),
                0, 5, 3));

        assertFalse(bidirectionalBFS.search(adjList.getGraphUndirected(false),
                0, 5, 7));
    }
}
