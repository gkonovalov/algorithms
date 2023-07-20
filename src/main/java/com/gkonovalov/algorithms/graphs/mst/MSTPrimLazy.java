package com.gkonovalov.algorithms.graphs.mst;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Georgiy Konovalov on 5/07/2023.
 * <p>
 * Minimum Spanning Tree - Prim's algorithm lazy implementation.
 * The Prim's algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) in connected
 * undirected weighted graph (weights must be positive). The MST is a subset of the graph's edges that
 * connects all the vertices with the minimum total edge weight and doesn't have any cycles.
 * It starts with an arbitrary vertex and repeatedly adds the minimum-weight edge that connects a vertex
 * in the MST to a vertex outside the MST. It grows the MST from a single vertex until it spans all vertices.
 * In the lazy implementation of Prim's algorithm, a priority queue is used to store all the edges that connect
 * the explored and unexplored vertices. This implementation defers the actual edge relaxation until it is needed,
 * hence the name "lazy." It avoids unnecessary edge relaxation, improving efficiency when the graph
 * has a large number of edges.
 * </p>
 * Runtime Complexity: O(E log E).
 * Space Complexity:   O(V).
 */
public class MSTPrimLazy {

    private PriorityQueue<EdgeWeighted> minHeap;
    private List<EdgeWeighted> mst;
    private boolean[] visited;
    private double weight;

    public MSTPrimLazy(List<List<EdgeWeighted>> adjListWithWeight) {
        int numV = adjListWithWeight.size();
        this.minHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));
        this.visited = new boolean[numV];
        this.mst = new ArrayList<>();
        this.weight = 0;

        primMST(adjListWithWeight, 0);
    }

    private void primMST(List<List<EdgeWeighted>> adjListWithWeight, int startV) {
        scan(adjListWithWeight, startV);

        while (!minHeap.isEmpty()) {
            EdgeWeighted e = minHeap.poll();

            if (!visited[e.toV]) {
                mst.add(e);
                weight += e.weight;

                scan(adjListWithWeight, e.toV);
            }
        }
    }

    private void scan(List<List<EdgeWeighted>> graph, int startV) {
        visited[startV] = true;
        for (EdgeWeighted e : graph.get(startV)) {
            if (!visited[e.toV]) {
                minHeap.add(e);
            }
        }
    }

    public List<EdgeWeighted> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}


