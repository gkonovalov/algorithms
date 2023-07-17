package com.gkonovalov.datastructures.graphs;

import java.util.Objects;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph Weighted Edge construction.
 */
public class EdgeWeighted {
    public int fromV;
    public int toV;
    public double weight;

    public EdgeWeighted(int fromV) {
        this.fromV = fromV;
        this.weight = 0;
    }

    public EdgeWeighted(int toV, double weight) {
        this.toV = toV;
        this.weight = weight;
    }

    public EdgeWeighted(int fromV, int toV, double weight) {
        this.fromV = fromV;
        this.toV = toV;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof EdgeWeighted)) {
            return false;
        }

        EdgeWeighted c = (EdgeWeighted) o;

        return Objects.equals(fromV, c.fromV) &&
                Objects.equals(toV, c.toV) &&
                Objects.equals(weight, c.weight);
    }
}
