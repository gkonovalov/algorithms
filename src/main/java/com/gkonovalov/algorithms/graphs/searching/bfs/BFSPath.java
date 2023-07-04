package com.gkonovalov.algorithms.graphs.searching.bfs;

import java.util.*;


/**
 * Created by Georgiy Konovalov on 8/10/2020.
 * <p>
 * Breadth First Search (Path and Distance) implementation. BFS stands for Breadth-First Search.
 * It is a graph traversal algorithm that explores all the vertices of a graph or all the nodes
 * of a tree in breadth-first order, i.e., it visits all the nodes at the same level
 * (Level-order traversal) before moving to the next level.
 * BFS guarantees that all nodes reachable from the source node will be visited, and the algorithm
 * visits nodes in increasing order of their distance from the source node.
 * The algorithm can be used for finding the shortest path between two vertices, counting connected
 * components, checking bipartiteness, or exploring a graph level by level. It is particularly useful
 * for web crawling, as it allows indexing pages without going too deep, thereby avoiding excessive
 * resource usage.
 * BFS typically requires more memory compared to DFS, as it needs to maintain a queue of nodes to visit.
 * It' can be less memory efficient when dealing with large trees that have a wide width. In situations
 * where the solution is likely to be near the root of the tree, a breadth-first search (BFS) may be more
 * efficient. However, if the tree is very deep and solutions are rare, a depth-first search (DFS) might
 * take an excessively long time, while BFS could provide faster results.
 * BFS is particularly useful when the depth of the tree can vary or when a single answer is needed, such
 * as finding the shortest path in a maze. BFS performs better in this scenario because DFS is more likely
 * to explore a significant portion of the maze before reaching the goal, potentially wasting time.
 * </p>
 * Runtime Complexity: O(V+E) {@code bfs}.
 * Space Complexity: O(V)
 */
public class BFSPath {
    private boolean[] visited;
    private int[] dist;
    private int[] prev;

    private int sourceVertex;

    public BFSPath(List<List<Integer>> adjList, int sourceVertex) {
        this.sourceVertex = sourceVertex;
        this.dist = new int[adjList.size()];
        this.prev = new int[adjList.size()];
        this.visited = new boolean[adjList.size()];

        Arrays.fill(dist, -1);
        Arrays.fill(prev, -1);

        bfs(adjList, sourceVertex);
    }

    private void bfs(List<List<Integer>> adjList, int startVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startVertex);

        visited[startVertex] = true;
        dist[startVertex] = 0;

        while (!queue.isEmpty()) {
            Integer fromVertex = queue.poll();

            for (Integer toVertex : adjList.get(fromVertex)) {
                if (!visited[toVertex]) {
                    visited[toVertex] = true;
                    prev[toVertex] = fromVertex;
                    dist[toVertex] = dist[fromVertex] + 1;
                    queue.add(toVertex);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public int distTo(int endV) {
        if (!hasPathTo(endV)) {
            return -1;
        }
        return dist[endV];
    }

    public List<Integer> pathTo(int endV) {
        if (!hasPathTo(endV)) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        for (int x = endV; x != sourceVertex; x = prev[x]) {
            path.add(0, x);
        }
        path.add(0, sourceVertex);

        return path;
    }
}
