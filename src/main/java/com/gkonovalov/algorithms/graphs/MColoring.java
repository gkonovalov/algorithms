package com.gkonovalov.algorithms.graphs;

/**
 * Implementation of Graph m-coloring algorithm.
 * The m-coloring algorithm is a graph coloring algorithm that aims to assign colors to the vertices
 * of a graph such that no two adjacent vertices have the same color, using a maximum of m colors.
 * The goal is to find a valid coloring with the minimum number of colors.
 * In the worst-case scenario, where no valid coloring can be found with m colors, the algorithm needs
 * to try all possible color combinations for each vertex. It's important to note that the m-coloring
 * problem is NP-hard, which means that for large graphs, finding an optimal coloring with the minimum
 * number of colors becomes computationally challenging. In such cases, approximation algorithms or
 * heuristic approaches are often used to find reasonably good colorings within a reasonable time frame.
 * </p>
 * Runtime Complexity: O(2^n n)
 */
public class MColoring {

    public int[] graphMColoring(int[][] graph, int totalColors) {
        int[] colors = new int[graph.length];

        if (graphColoringHelper(graph, colors, totalColors, 0)) {
            return colors;
        }

        return null;
    }

    private boolean graphColoringHelper(int[][] graphMatrix, int[] colors, int totalColors, int v) {
        if (v == colors.length) {
            return true;
        }

        for (int color = 1; color <= totalColors; color++) {
            if (isSafeToColor(graphMatrix, colors, v, color)) {
                colors[v] = color;

                if (graphColoringHelper(graphMatrix, colors, totalColors, v + 1)) {
                    return true;
                }

                colors[v] = 0;
            }
        }

        return false;
    }

    private boolean isSafeToColor(int[][] graphMatrix, int[] colors, int fromV, int color) {
        for (int toV = 0; toV < colors.length; toV++) {
            if (graphMatrix[fromV][toV] == 1 && color == colors[toV]) {
                return false;
            }
        }
        return true;
    }
}
