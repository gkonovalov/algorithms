package com.gkonovalov.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of Bipartite Graph Check algorithm.
 * A bipartite graph is a type of graph whose vertex set can be divided into two disjoint sets
 * such that every edge in the graph connects a vertex from one set to a vertex in the other set.
 * In other words, a bipartite graph is a graph that can be colored using only two colors in such
 * a way that no two adjacent vertices have the same color.
 * Formally, a graph G = (V, E) is bipartite if the vertex set V can be partitioned into two sets,
 * V1 and V2, such that every edge in E connects a vertex from V1 to a vertex from V2.
 * </p>
 * Runtime Complexity: O(|V|+|E|).
 * Space Complexity:   O(V).
 */
public class Bipartite {
    
    public boolean isBipartiteColoring(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        int[] colors = new int[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (colors[v] == 0 && !isBipartiteDfsColoring(adjList, colors, 1, v)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartiteDfsColoring(List<List<Integer>> adjList, int[] colors, int color, int v) {
        if (colors[v] != 0) {
            return colors[v] == color;
        }

        colors[v] = color;

        for (int nextV : adjList.get(v)) {
            if (!isBipartiteDfsColoring(adjList, colors, -color, nextV)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteDfsColoring(boolean[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        int[] colors = new int[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (colors[v] == 0 && !isBipartiteDfsColoring(adjMatrix, colors, 1, v)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartiteDfsColoring(boolean[][] adjMatrix, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int next = 0; next < adjMatrix[node].length; next++) {
            if (adjMatrix[node][next] && !isBipartiteDfsColoring(adjMatrix, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBFSColoring(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        int[] colors = new int[numVertices];

        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (colors[vertex] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertex);
            colors[vertex] = 1;

            while (!queue.isEmpty()) {
                int curV = queue.poll();

                for (int nextV : adjList.get(curV)) {
                    if (colors[nextV] == 0) {
                        colors[nextV] = -colors[curV];
                        queue.add(nextV);
                    } else if (colors[nextV] != -colors[curV]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteIterativeDFSColoring(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        int[] colors = new int[numVertices];

        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (colors[vertex] != 0) continue;

            Stack<Integer> stack = new Stack<>();
            stack.push(vertex);
            colors[vertex] = 1;

            while (!stack.empty()) {
                Integer curV = stack.pop();

                for (int nextV : adjList.get(curV)) {
                    if (colors[nextV] == colors[curV]) {
                        return false;
                    }

                    if (colors[nextV] == 0) {
                        colors[nextV] = -colors[curV];
                        stack.push(nextV);
                    }
                }
            }
        }
        return true;
    }
}
