package com.gkonovalov.datastructures.graphs;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph Wighted Node construction.
 *
 */
public class NodeWeighted {
    public Integer v;
    public Integer weight;

    public NodeWeighted(Integer v, Integer weight) {
        this.v = v;
        this.weight = weight;
    }
}
