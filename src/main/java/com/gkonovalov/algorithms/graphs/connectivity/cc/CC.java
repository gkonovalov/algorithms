package com.gkonovalov.algorithms.graphs.connectivity.cc;

import java.util.LinkedList;
import java.util.List;

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
 * Runtime Complexity: O(V+E)
 * Space Complexity: O(V).
 */
public class CC {

    private int[] id;
    private int[] size;
    private int count;

    public CC(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];
        this.id = new int[numVertices];
        this.size = new int[numVertices];
        this.count = 0;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                dfs(adjList, visited, v);
                count++;
            }
        }
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int fromV) {
        visited[fromV] = true;
        id[fromV] = count;
        size[count]++;

        for (int toV : adjList.get(fromV)) {
            if (!visited[toV]) {
                dfs(adjList, visited, toV);
            }
        }
    }

    public int connectedComponentsCount() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public int size(int v) {
        return size[id[v]];
    }

    public boolean isConnected(int a, int b) {
        return id[a] == id[b];
    }

    public List<List<Integer>> connectedComponents() {
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            result.add(new LinkedList<>());
        }

        for (int i = 0; i < id.length; i++) {
            result.get(id[i]).add(i);
        }

        return result;
    }
}
