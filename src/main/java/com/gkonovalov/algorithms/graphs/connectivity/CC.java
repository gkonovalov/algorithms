package com.gkonovalov.algorithms.graphs.connectivity;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Connected Components implementation. In graph theory, connected components refer to subsets of
 * vertices within a graph, where each vertex in a subset is connected to every other vertex in
 * the same subset. In simpler terms, a connected component is a group of vertices that are
 * directly or indirectly connected to each other, but not connected to any vertices outside of
 * that group. In a graph, the presence of multiple connected components indicates that the graph
 * is not fully connected, meaning there are distinct subgroups of vertices that have no connection
 * or path between them. Each connected component represents a separate "island" or "cluster" within
 * the graph. There are several algorithms to determine the connected components in a graph, such as
 * depth-first search (DFS) or breadth-first search (BFS). These algorithms traverse the graph,
 * visiting all reachable vertices from a starting vertex and marking them as part of the same
 * connected component. By repeating this process for all unvisited vertices, we can identify
 * all the connected components in the graph.
 * </p>
 * Runtime Complexity: O(V+E) {@code countConnectedComponentsDfs}, {@code countConnectedComponentsBfs}
 * Space Complexity: O(V).
 */
public class CC {

    public int countConnectedComponentsDfs(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];
        int components = 0;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                dfs(adjList, visited, v);
                components++;
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int fromVertex) {
        visited[fromVertex] = true;
        for (int toVertex : adjList.get(fromVertex)) {
            if (!visited[toVertex]) {
                dfs(adjList, visited, toVertex);
            }
        }
    }

    public int countConnectedComponentsDfs(boolean[][] matrix) {
        int numVertices = matrix.length;
        boolean[] visited = new boolean[numVertices];
        int components = 0;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                dfs(matrix, visited, v);
                components++;
            }
        }

        return components;
    }

    private void dfs(boolean[][] matrix, boolean[] visited, int fromVertex) {
        visited[fromVertex] = true;
        for (int toVertex = 0; toVertex < matrix[fromVertex].length; toVertex++) {
            if (!visited[toVertex] && matrix[fromVertex][toVertex]) {
                dfs(matrix, visited, toVertex);
            }
        }
    }

    public int countConnectedComponentsBfs(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];
        int components = 0;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                bfs(adjList, visited, v);
                components++;
            }
        }

        return components;
    }

    public void bfs(List<List<Integer>> adjList, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();
            visited[fromVertex] = true;

            for (int toVertex : adjList.get(fromVertex)) {
                if (!visited[toVertex]) {
                    queue.add(toVertex);
                }
            }
        }
    }

    public int countConnectedComponentsBfs(boolean[][] matrix) {
        int numVertices = matrix.length;
        boolean[] visited = new boolean[numVertices];
        int components = 0;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                bfs(matrix, visited, v);
                components++;
            }
        }

        return components;
    }

    public void bfs(boolean[][] matrix, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();
            visited[fromVertex] = true;

            for (int toVertex = 0; toVertex < matrix.length; toVertex++) {
                if (matrix[fromVertex][toVertex] && !visited[toVertex]) {
                    queue.add(toVertex);
                }
            }
        }
    }
}
