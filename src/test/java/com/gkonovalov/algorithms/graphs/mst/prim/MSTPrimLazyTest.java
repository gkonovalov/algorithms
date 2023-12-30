package com.gkonovalov.algorithms.graphs.mst.prim;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;
import com.gkonovalov.datastructures.graphs.representation.AdjacencyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tests for {@link MSTPrimLazy}.
 * </p
 */
public class MSTPrimLazyTest {

    private MSTPrimLazy mst;

    @BeforeEach
    public void setUp() {
        AdjacencyList adjacencyList = new AdjacencyList();
        this.mst = new MSTPrimLazy(adjacencyList.getGraphWeightedUndirected());
    }

    @Test
    @DisplayName("Testing MSTPrimLazy.weight")
    public void testWeight() {
        assertEquals(181, mst.weight());
    }

    @Test
    @DisplayName("Testing MSTPrimLazy.edges")
    public void testEdges() {
        assertEquals(mst.edges(), List.of(
                new EdgeWeighted(0, 7, 16),
                new EdgeWeighted(7, 1, 19),
                new EdgeWeighted(0, 2, 26),
                new EdgeWeighted(2, 3, 17),
                new EdgeWeighted(7, 5, 28),
                new EdgeWeighted(5, 4, 35),
                new EdgeWeighted(2, 6, 40))
        );
    }
}
