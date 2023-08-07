package com.gkonovalov.algorithms.graphs.connectivity;

import java.util.List;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * Implementation of Graph connectivity algorithm. Graph connectivity refers to the property of a graph
 * that determines whether all its vertices (nodes) are connected or not. In a connected graph, there is
 * a path between every pair of vertices, meaning that you can reach any vertex from any other vertex by
 * following a sequence of edges. If there is no such path between any two vertices, the graph is
 * considered disconnected, and it can be divided into two or more separate components.
 * Formally, an undirected graph is said to be connected if there exists a path between every pair of
 * vertices in the graph. In other words, every vertex in the graph is reachable from any other vertex.
 * On the other hand, a disconnected graph consists of two or more subgraphs (also called components),
 * where each subgraph is itself a connected graph, but there are no edges connecting different components.
 * Each subgraph is isolated from the other subgraphs, and there is no way to reach a vertex in one
 * subgraph from a vertex in another subgraph.
 * </p>
 * Runtime Complexity: O(|V|+|E|).
 * Space Complexity:   O(|V|).
 */
public class Connectivity {

    private boolean[] visited;

    public Connectivity(List<List<Integer>> adjList) {
        int vertices = adjList.size();

        this.visited = new boolean[vertices];

        dfs(adjList, 0);
    }

    private void dfs(List<List<Integer>> adjList, int fromV) {
        visited[fromV] = true;
        for (int toV : adjList.get(fromV)) {
            if (!visited[toV]) {
                dfs(adjList, toV);
            }
        }
    }

    public boolean isConnected() {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
