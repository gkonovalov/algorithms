package com.gkonovalov.algorithms.graphs.mst;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;
import com.gkonovalov.datastructures.trees.heaps.IndexedBinaryHeap;

import java.util.*;

import static com.gkonovalov.datastructures.trees.heaps.IndexedBinaryHeap.Type.MIN;

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
 * Space Complexity:   O(E).
 */
public class MSTPrim {

    private IndexedBinaryHeap<Double> minHeap;
    private EdgeWeighted[] prev;
    private double[] dist;
    private boolean[] visited;

    public MSTPrim(List<List<EdgeWeighted>> adjListWithWeight) {
        int numV = adjListWithWeight.size();
        this.minHeap = new IndexedBinaryHeap<>(numV, MIN);
        this.visited = new boolean[numV];
        this.dist = new double[numV];
        this.prev = new EdgeWeighted[numV];

        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        prim(adjListWithWeight, 0);
    }

    private void prim(List<List<EdgeWeighted>> adjListWithWeight, int startV) {
        dist[startV] = 0.0;
        minHeap.insert(startV, dist[startV]);

        while (!minHeap.isEmpty()) {
            int fromV = minHeap.pollIndex();

            if (!visited[fromV]) {
                scan(adjListWithWeight, fromV);
            }
        }
    }

    private void scan(List<List<EdgeWeighted>> adjListWithWeight, int startV) {
        visited[startV] = true;

        for (EdgeWeighted e : adjListWithWeight.get(startV)) {
            if (visited[e.toV]) {
                continue;
            }

            if (e.weight < dist[e.toV]) {
                dist[e.toV] = e.weight;
                prev[e.toV] = e;

                if (minHeap.contains(e.toV)) {
                    minHeap.decreaseKey(e.toV, dist[e.toV]);
                } else {
                    minHeap.insert(e.toV, dist[e.toV]);
                }
            }
        }
    }

    public List<EdgeWeighted> edges() {
        List<EdgeWeighted> mst = new ArrayList<>();
        for (int v = 0; v < prev.length; v++) {
            EdgeWeighted e = prev[v];
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


