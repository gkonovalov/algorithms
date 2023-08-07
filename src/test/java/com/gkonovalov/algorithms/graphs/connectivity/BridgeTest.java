package com.gkonovalov.algorithms.graphs.connectivity;

import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * Tests for {@link Bridge}.
 * </p
 */
public class BridgeTest {

    private Bridge bridge;
    private AdjacencyList adjList;

    @BeforeEach
    public void setUp() {
        this.adjList = new AdjacencyList();
        this.bridge = new Bridge(adjList.getGraphUndirected(true));
    }

    @Test
    @DisplayName("Testing Bridge.getBridges with AdjacencyList")
    public void testGetBridges() {
        assertEquals(bridge.getBridges(), List.of(List.of(0, 2), List.of(4, 5)));
    }
}
