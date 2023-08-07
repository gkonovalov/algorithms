package com.gkonovalov.algorithms.graphs.connectivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * Implementation of Bridge algorithm. The Bridges Algorithm, also known as the Bridge-Finding Algorithm
 * or Cut Edge Algorithm, is a graph algorithm used to identify all the bridges in an undirected graph.
 * A bridge is an edge in the graph whose removal would increase the number of connected components,
 * meaning that it plays a crucial role in maintaining connectivity in the graph.
 * Formally, an edge (u, v) is considered a bridge if and only if its removal disconnects the graph, i.e.,
 * the graph becomes disconnected, and the number of connected components increases. Bridges are essential
 * in network design, fault-tolerance analysis, and various communication systems, as they represent
 * critical connections whose failure could lead to network partitioning.
 * The Bridges Algorithm typically employs Depth-First Search (DFS) or a similar graph traversal technique
 * to identify bridges efficiently. During the DFS, the algorithm assigns discovery times and low-link
 * values to each vertex. The low-link value of a vertex indicates the earliest vertex that can be reached
 * from it, either directly or through a back edge. If an edge (u, v) has a higher low-link value than the
 * discovery time of vertex u, then it is a bridge.
 * The algorithm's key idea is to identify back edges in the DFS traversal, as they indicate cycles or
 * potential loops in the graph. By comparing the low-link values of adjacent vertices, it's possible to
 * detect bridges efficiently.
 * </p>
 * Runtime Complexity: O(|V|+|E|).
 * Space Complexity:   O(|V|).
 */
public class Bridge {
    private List<List<Integer>> bridges;
    private int count;
    private int[] pre;
    private int[] low;

    public Bridge(List<List<Integer>> adjList) {
        int vertices = adjList.size();

        this.low = new int[vertices];
        this.pre = new int[vertices];
        this.bridges = new ArrayList<>();

        Arrays.fill(low, -1);
        Arrays.fill(pre, -1);

        for (int v = 0; v < vertices; v++) {
            if (pre[v] == -1) {
                dfs(adjList, v, v);
            }
        }
    }

    private void dfs(List<List<Integer>> adjList, int u, int v) {
        pre[v] = count++;
        low[v] = pre[v];

        for (int w : adjList.get(v)) {
            if (pre[w] == -1) {
                dfs(adjList, v, w);

                low[v] = Math.min(low[v], low[w]);

                if (low[w] == pre[w]) {
                    bridges.add(Arrays.asList(v, w));
                }
            } else if (w != u) {
                low[v] = Math.min(low[v], pre[w]);
            }
        }
    }

    public List<List<Integer>> getBridges() {
        return bridges;
    }
}
