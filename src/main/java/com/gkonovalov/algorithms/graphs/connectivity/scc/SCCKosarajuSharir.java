package com.gkonovalov.algorithms.graphs.connectivity.scc;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Strongly Connected Components Kosaraju-Sharir algorithm implementation.
 * The Strongly Connected Components (SCC) algorithm is used to identify groups of vertices in a
 * Directed Graph where each vertex in a group is reachable from every other vertex in that group.
 * In other words, it helps find clusters of closely interconnected vertices in a directed graph.
 * Basically, we need to compute the reverse post-order of the reversed graph and then traverse it in
 * that order using DFS.
 * </p>
 * Runtime Complexity: O(V+E).
 * Space Complexity: O(V).
 */
public class SCCKosarajuSharir {
    private int[] id;
    private int count;
    private int numVertices;

    public SCCKosarajuSharir(List<List<Integer>> adjList) {
        this.numVertices = adjList.size();
        this.id = new int[numVertices];
        this.count = 0;

        Stack<Integer> reversePostOrder = getPostOrder(reverseGraph(adjList));

        boolean[] visited = new boolean[numVertices];
        while (!reversePostOrder.isEmpty()) {
            int v = reversePostOrder.pop();

            if (!visited[v]) {
                markReachableNodes(adjList, visited, v);
                count++;
            }
        }
    }

    private void markReachableNodes(List<List<Integer>> adjList, boolean[] visited, int fromV) {
        visited[fromV] = true;
        id[fromV] = count;
        for (int toV : adjList.get(fromV)) {
            if (!visited[toV]) {
                markReachableNodes(adjList, visited, toV);
            }
        }
    }

    private List<List<Integer>> reverseGraph(List<List<Integer>> adjList) {
        List<List<Integer>> reversed = new LinkedList<>();
        for (int fromV = 0; fromV < numVertices; fromV++) {
            reversed.add(new LinkedList<>());
        }

        for (int fromV = 0; fromV < numVertices; fromV++) {
            for (int toV : adjList.get(fromV)) {
                reversed.get(toV).add(fromV);
            }
        }
        return reversed;
    }

    private Stack<Integer> getPostOrder(List<List<Integer>> adjListReversed) {
        Stack<Integer> result = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                dfsReversePostOrder(adjListReversed, result, visited, v);
            }
        }
        return result;
    }

    private void dfsReversePostOrder(List<List<Integer>> adjListReversed, Stack<Integer> stack, boolean[] visited, int fromV) {
        visited[fromV] = true;
        for (int toV : adjListReversed.get(fromV)) {
            if (!visited[toV]) {
                dfsReversePostOrder(adjListReversed, stack, visited, toV);
            }
        }
        stack.push(fromV);
    }

    public int stronglyConnectedComponentsCount() {
        return count;
    }

    public boolean isStronglyConnected(int v1, int v2) {
        return id[v1] == id[v2];
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
