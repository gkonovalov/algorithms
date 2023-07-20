package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 18/07/2023.
 * <p>
 * Bellman-Ford algorithm implementation. Bellman-Ford algorithm is shortest path
 * algorithm used to find the shortest paths from a single source vertex to all other vertices
 * in a weighted graph. Unlike Dijkstra's algorithm, the Bellman-Ford algorithm can handle
 * graphs with negative edge weights and can detect "negative cycles", making it more
 * versatile in some scenarios. It's important to note that the presence of "negative cycles" can
 * make the shortest paths undefined since there is no finite solution. In practice, the
 * Bellman-Ford algorithm is often used for detecting negative cycles rather than finding the
 * shortest paths in graphs with negative weights. For finding shortest paths in graphs with
 * non-negative edge weights, Dijkstra's algorithm is a more efficient choice.
 * Bellman-Ford does not work with an undirected graph with negative edges as it will be declared
 * as a "negative cycles".
 * </p>
 * Runtime Complexity: O(|V||E|) {@code shortestPath}
 * Space Complexity: O(V)
 */
public class BellmanFord {

    private double[] dist;
    private Integer[] prev;

    public BellmanFord(List<List<EdgeWeighted>> adjListWithWeight, int startV) {
        int vertices = adjListWithWeight.size();

        this.dist = new double[vertices];
        this.prev = new Integer[vertices];

        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        shortestPath(adjListWithWeight, vertices, startV);
    }

    private void shortestPath(List<List<EdgeWeighted>> adjListWithWeight, int vertices, int startV) {
        dist[startV] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (List<EdgeWeighted> edges : adjListWithWeight) {
                for (EdgeWeighted e : edges) {
                    double newDistance = dist[e.fromV] + e.weight;

                    if (newDistance < dist[e.toV]) {
                        dist[e.toV] = newDistance;
                        prev[e.toV] = e.fromV;
                    }
                }
            }
        }

        detectNegativeCycles(adjListWithWeight, vertices);
    }

    private void detectNegativeCycles(List<List<EdgeWeighted>> adjListWithWeight, int vertices) {
        for (int i = 0; i < vertices - 1; i++) {
            for (List<EdgeWeighted> edges : adjListWithWeight) {
                for (EdgeWeighted e : edges) {
                    double newDistance = dist[e.fromV] + e.weight;

                    if (newDistance < dist[e.toV]) {
                        throw new RuntimeException("Can't compute shortest path in the Graph with negative cycle!");
                    }
                }
            }
        }
    }

    public double distTo(int v) {
        return dist[v];
    }

    public boolean hasPathTo(int v) {
        return dist[v] != Double.POSITIVE_INFINITY;
    }

    public List<Integer> pathTo(int endV) {
        if (!hasPathTo(endV)) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        for (Integer v = endV; v != null; v = prev[v]) {
            path.add(0, v);
        }

        return path;
    }
}
