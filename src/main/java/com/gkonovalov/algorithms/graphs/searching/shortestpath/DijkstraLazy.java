package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.NodeWeighted;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 4/07/2023.
 * <p>
 * Dijkstra's lazy algorithm implementation. The algorithm designed to find the shortest path
 * from a source node to all other nodes in a weighted graph it uses a greedy approach and
 * guarantees the shortest path, as long as the graph satisfies next condition: all edge weights
 * in the graph must be non-negative and the graph should be connected. Dijkstra's  maintains a set
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
public class DijkstraLazy {

    private PriorityQueue<NodeWeighted> minHeap;
    private int[] dist;
    private int[] prev;
    private boolean[] visited;
    private int sourceVertex;

    public DijkstraLazy(List<List<NodeWeighted>> adjListWithWeight, int sourceVertex) {
        int vertices = adjListWithWeight.size();

        this.sourceVertex = sourceVertex;
        this.visited = new boolean[vertices];
        this.dist = new int[vertices];
        this.prev = new int[vertices];
        this.minHeap = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstraShortestPath(adjListWithWeight, sourceVertex);
    }

    private void dijkstraShortestPath(List<List<NodeWeighted>> adjListWithWeight, int startV) {
        dist[startV] = 0;
        minHeap.add(new NodeWeighted(startV, 0));

        while (!minHeap.isEmpty()) {
            NodeWeighted from = minHeap.poll();

            visited[from.v] = true;

            if (from.weight > dist[from.v]) {
                continue;
            }

            for (NodeWeighted to : adjListWithWeight.get(from.v)) {
                if (visited[to.v]) {
                    continue;
                }

                int newDistance = dist[from.v] + to.weight;

                if (newDistance < dist[to.v]) {
                    prev[to.v] = from.v;
                    dist[to.v] = newDistance;

                    minHeap.add(new NodeWeighted(to.v, dist[to.v]));
                }
            }
        }
    }

    public int distTo(int v) {
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
