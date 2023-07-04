package com.gkonovalov.algorithms.graphs.searching.dfs;

import com.gkonovalov.algorithms.graphs.searching.dfs.DFSPath;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 4/07/2023.
 * <p>
 * Tests for {@link DFSPath}.
 * </p
 */
public class DFSPathTest {

    private DFSPath dfsPath;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjList = new AdjacencyList();
        this.dfsPath = new DFSPath(adjList.getGraphUndirected(false), 0);
    }

    @Test
    @DisplayName("Testing DFSPath.pathTo with AdjacencyList")
    public void testPathTo() {
        assertEquals(List.of(0, 1, 3), dfsPath.pathTo(3));
        assertNull(dfsPath.pathTo(4));
    }
}
