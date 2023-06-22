package com.gkonovalov.algorithms.graphs.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Tarjan's topological sorting implementation. The algorithm utilizes reverse DFS postorder.
 * Topological sorting is an algorithmic technique used to order the vertices of a directed acyclic graph (DAG)
 * in such a way that for every directed edge (u, v), vertex u comes before vertex v in the ordering.
 * Topological sorting is commonly used in scheduling tasks, dependency resolution, and in any scenario where a
 * partial order of elements needs to be established based on precedence or dependency relationships.
 * It's important to note that topological sorting is only applicable to directed acyclic graphs (DAGs).
 * If the graph contains cycles, it is not possible to determine a valid topological order.
 * It's worth mentioning that there are multiple algorithms for topological sorting, including
 * depth-first search (DFS), Kahn's algorithm using indegrees, and Tarjan's algorithm. Each algorithm has
 * its own advantages and use cases.
 * </p>
 * Runtime Complexity: O(V+E).
 * Space Complexity: O(V).
 */
public class TopologicalSortTarjan {

    public List<Integer> topologicalSort(List<List<Integer>> adjList) {
        int numVertices = adjList.size();

        Stack<Integer> sorted = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        boolean[] visitedOnStack = new boolean[numVertices];

        for (int fromV = 0; fromV < numVertices; fromV++) {
            if (!visited[fromV]) {
                if (!isValidDFS(adjList, sorted, visited, visitedOnStack, fromV)) {
                    return null;
                }
            }
        }

        List<Integer> reversed = new ArrayList<>();
        while (!sorted.isEmpty()) {
            reversed.add(sorted.pop());
        }

        return reversed;
    }

    private boolean isValidDFS(List<List<Integer>> adjList,
                             Stack<Integer> sorted,
                             boolean[] visited,
                             boolean[] visitedOnStack,
                             int fromV) {
        if (visitedOnStack[fromV]) {
            return false; //has cycle
        }

        if (visited[fromV]) {
            return true;
        }

        visited[fromV] = true;
        visitedOnStack[fromV] = true;

        for (int toV : adjList.get(fromV)) {
            if (!isValidDFS(adjList, sorted, visited, visitedOnStack, toV)) {
                return false;
            }
        }

        visitedOnStack[fromV] = false;
        sorted.push(fromV);

        return true;
    }
}
