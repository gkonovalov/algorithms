package com.gkonovalov.algorithms.graphs.mst;

import com.gkonovalov.algorithms.graphs.connectivity.unionfind.quickunion.QuickUnionWeightedPathCompression;
import com.gkonovalov.datastructures.graphs.EdgeWeighted;
import java.util.*;

/**
 * Created by Georgiy Konovalov on 5/07/2023.
 * <p>
 * Minimum Spanning Tree - Kruskal's algorithm implementation.
 * The Kruskal's algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) in connected
 * undirected weighted graph (weights must be positive).The MST is a subset of the graph's edges that
 * connects all the vertices with the minimum total edge weight and doesn't have any cycles.
 * The Kruskal's algorithm starts with the smallest-weight edge and iterates through the edges in
 * non-decreasing order. It adds edges to the MST as long as they do not create a cycle. It gradually builds
 * the MST by connecting vertices from different connected components, for this operations it utilize
 * Union Find data structure.
 * </p>
 * Runtime Complexity: O(E log* E).
 * Space Complexity:   O(V + E).
 */
public class MSTKruskal {

    private double weight;
    private List<EdgeWeighted> mst;

    public MSTKruskal(List<List<EdgeWeighted>> adjListWeighted) {
        this.mst = new ArrayList<>();
        this.weight = 0;

        kruskalMST(adjListWeighted);
    }

    private void kruskalMST(List<List<EdgeWeighted>> adjListWeighted) {
        int numV = adjListWeighted.size();

        PriorityQueue<EdgeWeighted> minHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));
        for (List<EdgeWeighted> edges : adjListWeighted) {
            minHeap.addAll(edges);
        }

        QuickUnionWeightedPathCompression uf = new QuickUnionWeightedPathCompression(numV);
        while (!minHeap.isEmpty() && mst.size() < numV - 1) {
            EdgeWeighted e = minHeap.poll();

            if (!uf.isConnected(e.fromV, e.toV)) {
                uf.union(e.fromV, e.toV);
                mst.add(e);
                weight += e.weight;
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
