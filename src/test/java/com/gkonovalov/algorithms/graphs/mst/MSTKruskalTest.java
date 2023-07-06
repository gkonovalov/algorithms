package com.gkonovalov.algorithms.graphs.mst;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import com.gkonovalov.datastructures.graphs.representation.EdgeList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tests for {@link MSTKruskal}.
 * </p
 */
public class MSTKruskalTest {
    private MSTKruskal mst;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.mst = new MSTKruskal(adjacencyList.getGraphWeightedUndirected());
    }

    @Test
    @DisplayName("Testing MSTKruskal.weight")
    public void testWeight() {
        assertEquals(181, mst.weight());
    }

    @Test
    @DisplayName("Testing MSTKruskal.edges")
    public void testEdges() {
        assertEquals(mst.edges(), List.of(
                new EdgeWeighted(0, 7, 16),
                new EdgeWeighted(2, 3, 17),
                new EdgeWeighted(1, 7, 19),
                new EdgeWeighted(0, 2, 26),
                new EdgeWeighted(5, 7, 28),
                new EdgeWeighted(4, 5, 35),
                new EdgeWeighted(2, 6, 40))
        );
    }
}
