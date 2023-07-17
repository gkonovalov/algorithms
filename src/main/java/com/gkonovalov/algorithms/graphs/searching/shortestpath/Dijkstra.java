package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.NodeWeighted;
import com.gkonovalov.datastructures.trees.heaps.IndexBinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gkonovalov.datastructures.trees.heaps.IndexBinaryHeap.Type.MIN;

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
 * Runtime Complexity: O(|V|+|E|log|V|) {@code dijkstraShortestPath}
 * Space Complexity: O(V)
 */
public class Dijkstra {

    private IndexBinaryHeap<Double> minHeap;
    private double[] dist;
    private int[] prev;
    private boolean[] visited;
    private int sourceVertex;

    public Dijkstra(List<List<NodeWeighted>> adjListWithWeight, int sourceVertex) {
        int vertices = adjListWithWeight.size();

        this.sourceVertex = sourceVertex;
        this.visited = new boolean[vertices];
        this.dist = new double[vertices];
        this.prev = new int[vertices];
        this.minHeap = new IndexBinaryHeap<>(vertices, MIN);

        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstraShortestPath(adjListWithWeight, sourceVertex);
    }

    private void dijkstraShortestPath(List<List<NodeWeighted>> adjListWithWeight, int startV) {
        dist[startV] = 0;
        minHeap.insert(startV, dist[startV]);

        while (!minHeap.isEmpty()) {
            double weight = minHeap.peekKey();
            int fromV = minHeap.poll();

            visited[fromV] = true;

            if (dist[fromV] < weight) {
                continue;
            }

            for (NodeWeighted to : adjListWithWeight.get(fromV)) {
                if (!visited[to.v]) {
                    double newDistance = dist[fromV] + to.weight;

                    if (newDistance < dist[to.v]) {
                        prev[to.v] = fromV;
                        dist[to.v] = newDistance;

                        if (minHeap.contains(to.v)) {
                            minHeap.decreaseKey(to.v, dist[to.v]);
                        } else {
                            minHeap.insert(to.v, dist[to.v]);
                        }
                    }
                }
            }
        }
    }

    public double distTo(int v) {
        return dist[v];
    }

    public boolean hasPathTo(int v) {
        return dist[v] != Integer.MAX_VALUE;
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
