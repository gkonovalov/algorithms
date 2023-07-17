package com.gkonovalov.datastructures.graphs;

import java.util.Objects;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph Weighted Edge construction.
 */
public class EdgeWeighted {
    public Integer fromV;
    public Integer toV;
    public Integer weight;

    public EdgeWeighted(Integer fromV) {
        this.fromV = fromV;
        this.weight = 0;
    }

    public EdgeWeighted(Integer toV, Integer weight) {
        this.toV = toV;
        this.weight = weight;
    }

    public EdgeWeighted(Integer fromV, Integer toV, Integer weight) {
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
