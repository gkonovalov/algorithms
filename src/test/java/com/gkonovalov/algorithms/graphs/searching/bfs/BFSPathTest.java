package com.gkonovalov.algorithms.graphs.searching.bfs;

import com.gkonovalov.algorithms.graphs.searching.bfs.BFSPath;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Georgiy Konovalov on 4/07/2023.
 * <p>
 * Tests for {@link BFSPath}.
 * </p
 */
public class BFSPathTest {

    private BFSPath bfsPath;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjList = new AdjacencyList();
        this.bfsPath = new BFSPath(adjList.getGraphUndirected(false), 0);
    }

    @Test
    @DisplayName("Testing BFSPath.pathTo with AdjacencyList")
    public void testPathTo() {
        assertEquals(List.of(0, 1, 3), bfsPath.pathTo(3));
        assertNull(bfsPath.pathTo(4));
    }

    @Test
    @DisplayName("Testing BFSPath.distTo with AdjacencyList")
    public void testDistTo() {
        assertEquals(2, bfsPath.distTo(3));
        assertEquals(-1, bfsPath.distTo(4));
    }
}
