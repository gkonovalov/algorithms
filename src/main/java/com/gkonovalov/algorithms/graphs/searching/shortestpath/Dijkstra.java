package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;
import com.gkonovalov.datastructures.trees.heaps.IndexedBinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gkonovalov.datastructures.trees.heaps.IndexedBinaryHeap.Type.MIN;

/**
 * Created by Georgiy Konovalov on 4/07/2023.
 * <p>
 * Dijkstra's eager algorithm implementation. The algorithm designed to find the shortest path
 * from a source node to all other nodes in a weighted graph it uses a greedy approach and
 * guarantees the shortest path, as long as the graph satisfies next condition: all edge weights
 * in the graph must be non-negative and the graph should be connected. Dijkstra's maintains a set
 * of vertices for which the shortest path has been determined and gradually expands this set until
 * all vertices have been included. At each iteration, the algorithm selects the vertex with the
 * minimum distance from the source among the unvisited vertices and relaxes its neighboring vertices
 * to potentially update their distances. However it does not provide an efficient solution for finding
 * the shortest path between any pair of nodes in the graph. To find the shortest path between all pairs
 * of nodes, a different algorithm such as the Floyd-Warshall or Bellman-Ford algorithms
 * may be more appropriate.
 * </p>
 * Runtime Complexity: O(|V|+|E|log|V|) {@code shortestPath}
 * Space Complexity: O(V)
 */
public class Dijkstra {

    private IndexedBinaryHeap<Double> minHeap;
    private double[] dist;
    private Integer[] prev;
    private boolean[] visited;

    public Dijkstra(List<List<EdgeWeighted>> adjListWithWeight, int sourceVertex) {
        int vertices = adjListWithWeight.size();

        this.visited = new boolean[vertices];
        this.dist = new double[vertices];
        this.prev = new Integer[vertices];
        this.minHeap = new IndexedBinaryHeap<>(vertices, MIN);

        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        shortestPath(adjListWithWeight, sourceVertex);
    }

    private void shortestPath(List<List<EdgeWeighted>> adjListWithWeight, int startV) {
        dist[startV] = 0;
        minHeap.insert(startV, dist[startV]);

        while (!minHeap.isEmpty()) {
            int fromV = minHeap.pollIndex();

            if (!visited[fromV]) {
                relax(adjListWithWeight, fromV);
            }
        }
    }

    private void relax(List<List<EdgeWeighted>> adjListWithWeight, int startV) {
        visited[startV] = true;

        for (EdgeWeighted e : adjListWithWeight.get(startV)) {
            if (!visited[e.toV]) {
                double newDistance = dist[startV] + e.weight;

                if (newDistance < dist[e.toV]) {
                    prev[e.toV] = startV;
                    dist[e.toV] = newDistance;

                    if (minHeap.contains(e.toV)) {
                        minHeap.decreaseKey(e.toV, dist[e.toV]);
                    } else {
                        minHeap.insert(e.toV, dist[e.toV]);
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
