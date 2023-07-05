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

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int startV) {
        visited[startV] = true;
        stack.push(startV);

        low[startV] = pre++;
        int min = low[startV];

        for (int toV : adjList.get(startV)) {
            if (!visited[toV]) {
                dfs(adjList, visited, toV);
            }
            min = Math.min(min, low[toV]);
        }

        if (min < low[startV]) {
            low[startV] = min;
            return;
        }

        while (!stack.isEmpty()) {
            int v = stack.pop();
            id[v] = count;
            low[v] = numVertices;

            if (v == startV) {
                break;
            }
        }
        count++;
    }

    public int stronglyConnectedComponentsCount() {
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
