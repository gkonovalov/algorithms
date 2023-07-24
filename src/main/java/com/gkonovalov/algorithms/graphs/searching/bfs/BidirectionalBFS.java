package com.gkonovalov.algorithms.graphs.searching.bfs;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 23/07/2023.
 * <p>
 * Bidirectional BFS Search implementation. Bidirectional search is a graph search algorithm used to find
 * the shortest path between two nodes in a graph. It is an extension of the traditional graph search
 * algorithms, such as Breadth-First Search (BFS) or Depth-First Search (DFS), which explore the graph
 * from a single starting point. In contrast, bidirectional search explores the graph simultaneously
 * from both the start and goal nodes, meeting in the middle when a common node is found. This approach
 * can be more efficient and faster, especially in scenarios where the branching factor (number of
 * possible moves from a node) is high.
 * </p>
 * Runtime Complexity: O(V+E) {@code bfsExample}, {@code search}.
 * Space Complexity: O(V).
 */
public class BidirectionalBFS {

    public boolean search(List<List<Integer>> adjList, int startV, int endV, int findVertex) {
        int vertices = adjList.size();

        Queue<Integer> queueStart = new ArrayDeque<>();
        Queue<Integer> queueEnd = new ArrayDeque<>();

        boolean[] visited = new boolean[vertices];

        queueStart.add(startV);
        visited[startV] = true;

        queueEnd.add(endV);
        visited[endV] = true;

        while (!queueStart.isEmpty() || !queueEnd.isEmpty()) {
            if (bfsSearch(adjList, queueStart, visited, findVertex) ||
                    bfsSearch(adjList, queueEnd, visited, findVertex)) {
                return true;
            }
        }
        return false;
    }

    private boolean bfsSearch(List<List<Integer>> adjList, Queue<Integer> queue, boolean[] visited, int findVertex) {
        if (queue.isEmpty()) {
            return false;
        }

        int fromV = queue.poll();

        if (fromV == findVertex) {
            return true;
        }

        for (int toV : adjList.get(fromV)) {
            if (!visited[toV]) {
                visited[toV] = true;
                queue.add(toV);
            }
        }
        return false;
    }
}