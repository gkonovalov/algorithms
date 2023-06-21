package com.gkonovalov.algorithms.graphs;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Implementation of Cycle Detection in Undirected and Directed Graphs.
 * In graph theory, a cycle in a graph is a path that starts and ends at the same vertex, without
 * traversing any other vertex more than once (except for the start/end vertex). In other words,
 * it is a closed loop in the graph that visits multiple vertices and edges.
 * Graphs without any cycles are called acyclic graphs, while graphs that contain at least one cycle
 * are cyclic graphs.
 * </p>
 * Runtime Complexity: O(|V|+|E|).
 * Space Complexity:   O(V).
 */
public class CycleDetection {

    public boolean hasCycleDFSUndirectedGraph(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && hasCycleDFSUndirectedGraph(adjList, visited, v, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleDFSUndirectedGraph(List<List<Integer>> adjList,
                                               boolean[] visited,
                                               Integer v,
                                               Integer parent) {
        visited[v] = true;

        for (Integer toV : adjList.get(v)) {
            if (!visited[toV]) {
                if (hasCycleDFSUndirectedGraph(adjList, visited, toV, v)) {
                    return true;
                }
            } else if (!toV.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleDFSDirectedGraph(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];
        boolean[] visitedOnStack = new boolean[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && hasCycleDFSDirectedGraph(adjList, visited, visitedOnStack, v)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleDFSDirectedGraph(List<List<Integer>> adjList,
                                             boolean[] visited,
                                             boolean[] visitedOnStack,
                                             Integer v) {
        if (visitedOnStack[v]) {
            return true;
        }

        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        visitedOnStack[v] = true;

        for (Integer toV : adjList.get(v)) {
            if (hasCycleDFSDirectedGraph(adjList, visited, visitedOnStack, toV)) {
                return true;
            }
        }

        visitedOnStack[v] = false;

        return false;
    }

    public boolean hasCycleUndirectedGraphBFS(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && hasCycleUndirectedGraphBFS(adjList, visited, v)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUndirectedGraphBFS(List<List<Integer>> adjList,
                                              boolean[] visited,
                                              int v) {
        int numVertices = adjList.size();
        int[] parent = new int[numVertices];

        Arrays.fill(parent, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);

        visited[v] = true;

        while (!queue.isEmpty()) {
            int fromV = queue.poll();

            for (int toV : adjList.get(fromV)) {
                if (visited[toV] && parent[fromV] != toV) {
                    return true;
                } else if (!visited[toV]) {
                    visited[toV] = true;
                    queue.add(toV);
                    parent[toV] = fromV;
                }
            }
        }
        return false;
    }
}
