package com.gkonovalov.algorithms.graphs.searching.shortestpath;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 20/07/2023.
 * <p>
 * A-Star algorithm implementation. A* is designed for finding the shortest path in
 * graphs with non-negative edge weights. It uses a heuristic function that estimates the cost
 * from each node to the goal node. The heuristic helps prioritize nodes that are more likely to
 * lead to the goal. A* is generally more efficient than Dijkstra's algorithm, especially
 * for large graphs.
 * Heuristic distance calculation:
 *  1) Manhattan,
 *  2) Euclidean,
 *  3) Octile,
 *  4) Chebyshev.
 *
 * F = G + H (total cost = cost from start + heuristic estimate)
 * </p>
 * Runtime Complexity: O(|V|+|E|) {@code shortestPath}
 * Space Complexity: O(V)
 */
public class AStar {

    private PriorityQueue<Node> minHeap;
    private double[] dist;
    private Integer[] prev;
    private boolean[] visited;
    private boolean hasPath;
    private int endV;

    public AStar(List<List<EdgeWeighted>> adjListWithWeight, int startV, int endV) {
        int vertices = adjListWithWeight.size();

        this.endV = endV;
        this.dist = new double[vertices];
        this.prev = new Integer[vertices];
        this.visited = new boolean[vertices];
        this.minHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> o.f));

        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        this.hasPath = shortestPath(adjListWithWeight, startV, endV);
    }

    private boolean shortestPath(List<List<EdgeWeighted>> adjListWithWeight, int startV, int endV) {
        dist[startV] = 0;
        minHeap.add(new Node(startV, dist[startV], heuristicEstimate(startV, endV)));

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();

            if (node.v == endV) {
                return true;
            }

            visited[node.v] = true;

            for (EdgeWeighted e : adjListWithWeight.get(node.v)) {
                if (!visited[e.toV]) {
                    double tentativeDistance = node.g + e.weight;

                    if (tentativeDistance < dist[e.toV]) {
                        prev[e.toV] = node.v;
                        dist[e.toV] = tentativeDistance;

                        minHeap.add(new Node(e.toV, dist[e.toV], heuristicEstimate(e.toV, endV)));
                    }
                }
            }
        }
        return false;
    }

    private int heuristicEstimate(int node, int goal) {
        return Math.abs(node - goal);
    }

    public List<Integer> path() {
        if (!hasPath) {
            return null;
        }

        List<Integer> path = new ArrayList<>();

        for (Integer v = endV; v != null; v = prev[v]) {
            path.add(0, v);
        }

        return path;
    }

    public double dist() {
        if (!hasPath) {
            return -1;
        }
        return dist[endV];
    }

    private class Node {
        public int v;
        public double g;
        public double h;
        public double f;

        public Node(int v, double g, double h) {
            this.v = v;
            this.g = g;
            this.h = h;
            this.f = g + h;
        }
    }
}