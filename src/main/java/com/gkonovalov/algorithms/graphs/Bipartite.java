package com.gkonovalov.algorithms.graphs;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of Bipartite Graph Check algorithm.
 * A bipartite graph is a graph whose vertices can be divided into two disjoint sets, let's call
 * them "Set A" and "Set B", such that every edge in the graph connects a vertex from Set A to a
 * vertex from Set B. In other words, there are no edges within the same set.
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

    public boolean isBipartiteDfsColoring(List<List<Integer>> adjList, int[] colors, int color, int v) {
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

    public boolean isBipartiteColoring2(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        int[] coloring = new int[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (isBipartiteDfsColoring2(adjList, v, coloring)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBipartiteDfsColoring2(List<List<Integer>> adjList, int v, int[] coloring) {
        if (coloring[v] != 0) {
            return coloring[v] == 2;
        }

        coloring[v] = 2;

        for (int nextV : adjList.get(v)) {
            if (isBipartiteDfsColoring2(adjList, nextV, coloring)) {
                return true;
            }
        }

        coloring[v] = 1;

        return false;
    }

    public boolean isBipartiteDfsColoring(int[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        int[] colors = new int[numVertices];

        for (int v = 0; v < numVertices; v++) {
            if (colors[v] == 0 && !isBipartiteDfsColoring(adjMatrix, colors, 1, v)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteDfsColoring(int[][] adjMatrix, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int next = 0; next < adjMatrix[node].length; next++) {
            if (adjMatrix[node][next] == 1 && !isBipartiteDfsColoring(adjMatrix, colors, -color, next)) {
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
