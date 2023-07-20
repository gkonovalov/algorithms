package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 20/07/2023.
 * <p>
 * Floyd Warshall's algorithm implementation. The Floyd-Warshall algorithm is a widely used
 * algorithm for finding the shortest paths between all pairs of vertices in a weighted graph.
 * It is an all-pairs shortest path algorithm that can handle both positive and negative edge
 * weights (but not "negative cycles") and works for both the directed and undirected weighted graphs.
 * The Floyd-Warshall algorithm well-suited for dense graphs (graphs with many edges) due to its
 * matrix-based approach. It also can detect negative cycles in the graph.
 * </p>
 * Runtime Complexity: O(V^3) {@code shortestPath}.
 * Space Complexity: O(V^2).
 */
public class FloydWarshall {

    private Integer[][] prev;
    private double[][] dist;

    public FloydWarshall(List<List<EdgeWeighted>> adjListWithWeight) {
        int vertices = adjListWithWeight.size();

        this.dist = new double[vertices][vertices];
        this.prev = new Integer[vertices][vertices];

        for (double[] row : dist) {
            Arrays.fill(row, Double.POSITIVE_INFINITY);
        }

        for (int v = 0; v < vertices; v++) {
            for (EdgeWeighted e : adjListWithWeight.get(v)) {
                dist[e.fromV][e.toV] = e.weight;
                prev[e.fromV][e.toV] = e.fromV;
            }

            if (dist[v][v] >= 0.0) {
                dist[v][v] = 0.0;
                prev[v][v] = null;
            }
        }

        shortestPath(vertices);
    }

    private void shortestPath(int vertices) {
        for (int i = 0; i < vertices; i++) {
            for (int v = 0; v < vertices; v++) {
                for (int w = 0; w < vertices; w++) {
                    double newDistance = dist[v][i] + dist[i][w];

                    if (newDistance < dist[v][w]) {
                        dist[v][w] = newDistance;
                        prev[v][w] = prev[i][w];
                    }
                }

                if (dist[v][v] < 0.0) {
                    throw new RuntimeException("Can't compute shortest path in the Graph with negative cycle!");
                }
            }
        }
    }

    public double dist(int fromV, int toV) {
        return dist[fromV][toV];
    }

    public boolean hasPathTo(int fromV, int toV) {
        return dist[fromV][toV] != Double.POSITIVE_INFINITY;
    }

    public List<Integer> pathTo(int fromV, int toV) {
        if (!hasPathTo(fromV, toV)) {
            return null;
        }

        List<Integer> result = new LinkedList<>();
        for (Integer v = toV; v != null ; v = prev[fromV][v]) {
            result.add(0, v);
        }

        return result;
    }
}
