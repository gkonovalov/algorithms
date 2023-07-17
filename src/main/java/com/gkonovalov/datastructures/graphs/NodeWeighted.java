package com.gkonovalov.datastructures.graphs;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph Weighted Node construction.
 *
 */
public class NodeWeighted {
    public int v;
    public double weight;

    public NodeWeighted(int v) {
        this.v = v;
        this.weight = 0;
    }

    public NodeWeighted(int v, double weight) {
        this.v = v;
        this.weight = weight;
    }
}
