package com.gkonovalov.algorithms.graphs.mst;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;
import com.gkonovalov.datastructures.trees.heaps.IndexBinaryHeap;

import java.util.*;

import static com.gkonovalov.datastructures.trees.heaps.IndexBinaryHeap.Type.MIN;

/**
 * Created by Georgiy Konovalov on 5/07/2023.
 * <p>
 * Minimum Spanning Tree - Prim's eager algorithm implementation.
 * The Prim's algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) in connected
 * undirected weighted graph (weights must be positive). The MST is a subset of the graph's edges that
 * connects all the vertices with the minimum total edge weight and doesn't have any cycles.
 * It starts with an arbitrary vertex and repeatedly adds the minimum-weight edge that connects a vertex
 * in the MST to a vertex outside the MST. It grows the MST from a single vertex until it spans all vertices.
 * In the eager implementation of Prim's algorithm, a key-value data structure (such as a min-heap) is used
 * to maintain the minimum-weight edges for each vertex. This implementation performs edge relaxation eagerly,
 * updating the priority queue as soon as a shorter path is found. It guarantees that the minimum-weight edge
 * is always considered first, at the cost of potential redundant edge relaxation.
 * </p>
 * Runtime Complexity: O(E log V).
 * Space Complexity:   O(V).
 */
public class MSTPrim {

    private IndexBinaryHeap<Double> minHeap;
    private EdgeWeighted[] edgeTo;
    private double[] distTo;
    private boolean[] visited;

    public MSTPrim(List<List<EdgeWeighted>> adjListWithWeight) {
        int numV = adjListWithWeight.size();
        this.minHeap = new IndexBinaryHeap<>(numV, MIN);
        this.visited = new boolean[numV];
        this.distTo = new double[numV];
        this.edgeTo = new EdgeWeighted[numV];

        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        prim(adjListWithWeight, 0);
    }

    private void prim(List<List<EdgeWeighted>> adjListWithWeight, int s) {
        distTo[s] = 0.0;
        minHeap.insert(s, distTo[s]);

        while (!minHeap.isEmpty()) {
            scan(adjListWithWeight, minHeap.poll());
        }
    }

    private void scan(List<List<EdgeWeighted>> adjListWithWeight, int v) {
        visited[v] = true;
        for (EdgeWeighted e : adjListWithWeight.get(v)) {
            if (!visited[e.toV] && e.weight < distTo[e.toV]) {
                distTo[e.toV] = e.weight;
                edgeTo[e.toV] = e;

                if (minHeap.contains(e.toV)) {
                    minHeap.decreaseKey(e.toV, distTo[e.toV]);
                } else {
                    minHeap.insert(e.toV, distTo[e.toV]);
                }
            }
        }
    }

    public List<EdgeWeighted> edges() {
        List<EdgeWeighted> mst = new ArrayList<>();
        for (int v = 0; v < edgeTo.length; v++) {
            EdgeWeighted e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (EdgeWeighted e : edges()) {
            weight += e.weight;
        }
        return weight;
    }
}


