package com.gkonovalov.problems.graph.bipartite;


/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/is-graph-bipartite/">
 *          [Medium][785] - Is Graph Bipartite?
 *      </a>
 * </p>
 * Runtime Complexity: O(|V|+|E|) for {@code isBipartite}.
 * Space Complexity:   O(V) for {@code isBipartite}.
 */
public class IsGraphBipartite {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        System.out.println("Is Graph Bipartite:" + isBipartite(arr));
    }

    public static boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] colors = new int[vertices];

        for (int v = 0; v < vertices; v++) {
            if (colors[v] == 0 && !canColor(graph, colors, 1, v)) {
                return false;
            }
        }
        return true;
    }

    private static boolean canColor(int[][] graph, int[] colors, int color, int fromV) {
        if (colors[fromV] != 0) {
            return colors[fromV] == color;
        }

        colors[fromV] = color;

        for (int toV : graph[fromV]) {
            if (!canColor(graph, colors, -color, toV)) {
                return false;
            }
        }
        return true;
    }
}
