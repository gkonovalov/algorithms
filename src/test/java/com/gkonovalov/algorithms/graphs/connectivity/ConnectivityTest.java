package com.gkonovalov.algorithms.graphs.connectivity;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * Tests for {@link Connectivity}.
 * </p
 */
public class ConnectivityTest {

    private Connectivity connectivity;
    private AdjacencyList adjList;

    @BeforeEach
    public void setUp() {
        this.adjList = new AdjacencyList();
        this.connectivity = new Connectivity(adjList.getGraphUndirected(true));
    }

    @Test
    @DisplayName("Testing Connectivity.isConnected with AdjacencyList")
    public void testGetBridges() {
        assertFalse(connectivity.isConnected());
    }
}
