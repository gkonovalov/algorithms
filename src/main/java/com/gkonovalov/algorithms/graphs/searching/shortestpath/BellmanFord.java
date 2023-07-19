package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.NodeWeighted;

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
    private int[] prev;
    private int sourceVertex;

    public BellmanFord(List<List<NodeWeighted>> adjListWithWeight, int startV) {
        int vertices = adjListWithWeight.size();

        this.sourceVertex = startV;
        this.dist = new double[vertices];
        this.prev = new int[vertices];

        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        shortestPath(adjListWithWeight, vertices, startV);
    }

    public void shortestPath(List<List<NodeWeighted>> adjListWithWeight, int vertices,  int startV) {
        dist[startV] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (int fromV = 0; fromV < vertices; fromV++) {
                for (NodeWeighted to : adjListWithWeight.get(fromV)) {
                    double newDistance = dist[fromV] + to.weight;

                    if (newDistance < dist[to.v]) {
                        dist[to.v] = newDistance;
                        prev[to.v] = fromV;
                    }
                }
            }
        }

        for (int i = 0; i < vertices - 1; i++) {
            for (int fromV = 0; fromV < vertices; fromV++) {
                for (NodeWeighted to : adjListWithWeight.get(fromV)) {
                    double newDistance = dist[fromV] + to.weight;

                    if (newDistance < dist[to.v]) {
                        dist[to.v] = Double.NEGATIVE_INFINITY;
                        prev[to.v] = -1;
                    }
                }
            }
        }
    }

    public double distTo(int v) {
        return dist[v];
    }

    public boolean hasPathTo(int v) {
        return dist[v] != Double.POSITIVE_INFINITY && dist[v] != Double.NEGATIVE_INFINITY;
    }

    public List<Integer> pathTo(int endV) {
        if (!hasPathTo(endV)) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = endV; v != sourceVertex; v = prev[v]) {
            path.add(0, v);
        }
        path.add(0, sourceVertex);

        return path;
    }
}
