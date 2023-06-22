package com.gkonovalov.algorithms.graphs.connectivity.scc;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Strongly Connected Components Tarjan algorithm implementation.
 * The Strongly Connected Components (SCC) algorithm is used to identify groups of vertices in a directed
 * graph where each vertex in a group is reachable from every other vertex in that group. In other words,
 * it helps find clusters of closely interconnected vertices in a directed graph.
 * Tarjan's algorithm is generally considered simpler to implement and suitable for various types of graphs,
 * while Kosaraju's algorithm offers a guaranteed linear time complexity and can be parallelized effectively.
 * </p>
 * Runtime Complexity: O(V+E).
 * Space Complexity: O(V).
 */
public class SCCTarjan {

    private Stack<Integer> stack;

    private int[] id;
    private int[] low;

    private int pre;
    private int count;

    private int numVertices;

    public SCCTarjan(List<List<Integer>> adjList) {
        this.numVertices = adjList.size();
        this.stack = new Stack<>();
        this.id = new int[numVertices];
        this.low = new int[numVertices];

        boolean[] visited = new boolean[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                dfs(adjList, visited, v);
            }
        }
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int v) {
        visited[v] = true;
        low[v] = pre++;
        int min = low[v];
        stack.push(v);

        for (int w : adjList.get(v)) {
            if (!visited[w]) {
                dfs(adjList, visited, w);
            }

            if (low[w] < min) {
                min = low[w];
            }
        }

        if (min < low[v]) {
            low[v] = min;
            return;
        }

        while (true) {
            int w = stack.pop();
            id[w] = count;
            low[w] = numVertices;

            if (w == v) {
                break;
            }
        }
        count++;
    }

    public int count() {
        return count;
    }

    public boolean isStronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public List<List<Integer>> stronglyConnectedComponents() {
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
