package com.gkonovalov.algorithms.graphs.searching.dfs;

import java.util.List;
import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Depth-First Search with Iterative Deepening implementation.
 * DFS-ID (Depth-First Search with Iterative Deepening) is a search algorithm that combines the
 * depth-first search (DFS) strategy with iterative deepening. It is commonly used in artificial
 * intelligence and graph traversal problems where the search space is large and the depth of the
 * solution is unknown. The main idea behind DFS-ID is to perform a series of depth-limited depth-first
 * searches with increasing depth limits. It starts with a depth limit of 0 and gradually increases the
 * depth limit in each iteration until the goal is found or the search space is exhausted.
 * </p>
 * Runtime Complexity: O(V+E) {@code searchDfsRecursive}, {@code searchDfsPreorderIterative}
 * Space Complexity: O(V)
 */
public class DFSID {

    public boolean searchRecursive(List<List<Integer>> adjList,
                                   int maxDepth,
                                   int startVertex,
                                   int findVertex) {
        boolean[] visited = new boolean[adjList.size()];

        return searchRecursive(adjList, visited, maxDepth, startVertex, findVertex);
    }

    private boolean searchRecursive(List<List<Integer>> adjList,
                                    boolean[] visited,
                                    int maxDepth,
                                    int fromVertex,
                                    int findDigit) {
        if (fromVertex == findDigit) {
            return true;
        }

        if (maxDepth <= 0) {
            return false;
        }

        visited[fromVertex] = true;

        for (Integer toVertex : adjList.get(fromVertex)) {
            if (!visited[toVertex]) {
                if (searchRecursive(adjList, visited, --maxDepth, toVertex, findDigit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchPreorderIterative(List<List<Integer>> adjList,
                                           boolean[] visited,
                                           int maxDepth,
                                           int startVertex,
                                           int findDigit) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer fromVertex = stack.pop();

            if (fromVertex.equals(findDigit)) {
                return true;
            }

            if (maxDepth <= 0) {
                return false;
            }

            for (Integer toVertex : adjList.get(fromVertex)) {
                if (!visited[toVertex]) {
                    visited[toVertex] = true;
                    stack.push(toVertex);
                }
            }
            maxDepth--;
        }
        return false;
    }
}
