package com.gkonovalov.algorithms.graphs.sorting.topological;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 21/06/2023.
 * <p>
 * Kahn's topological sorting implementation.
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
public class TopologicalSortKahn {

    public int[] topologicalSort(List<List<Integer>> adjList) {
        int numVertices = adjList.size();

        int[] indegree = new int[numVertices];

        for (int v = 0; v < numVertices; v++) {
            for (int toV : adjList.get(v)) {
                indegree[toV]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int v = 0; v < numVertices; v++) {
            if (indegree[v] == 0) {
                queue.add(v);
            }
        }

        int count = 0;
        int[] order = new int[numVertices];

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order[count++] = v;

            for (int w : adjList.get(v)) {
                indegree[w]--;

                if (indegree[w] == 0) {
                    queue.add(w);
                }
            }
        }

        if (count == numVertices) {
            return order;
        }
        return null;
    }
}
