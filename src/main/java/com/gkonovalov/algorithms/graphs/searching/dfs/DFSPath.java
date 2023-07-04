package com.gkonovalov.algorithms.graphs.searching.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Depth First Search (Path) implementation. DFS stands for Depth-First Search. It is an algorithm used
 * to traverse or search through a graph or tree data structure. DFS explores a path as deeply
 * as possible before backtracking and exploring other paths. DFS can be implemented using either
 * a recursive approach or an iterative approach with the help of a stack data structure to keep
 * track of nodes to be visited. DFS search is not well-suited for computing the shortest path,
 * but it excels in aggressive exploration, similar to navigating through a maze. It can also be
 * used to count connected components and topological sorting.
 * However, if the graph or tree is deep and solutions are rare, DFS might take a long time, whereas
 * BFS could be faster. On the other hand, if the tree is wide, DFS can significantly reduce memory
 * usage compared to BFS. Additionally, when it is known beforehand that the desired answer is likely
 * to be found deep within the tree, DFS is a better option than BFS.
 * </p>
 * Runtime Complexity: O(V+E) {@code dfs}.
 * Space Complexity: O(V).
 */
public class DFSPath {

    private boolean[] visited;
    private int[] prev;
    private final int sourceVertex;

    public DFSPath(List<List<Integer>> adjList, int sourceVertex) {
        this.sourceVertex = sourceVertex;
        this.prev = new int[adjList.size()];
        this.visited = new boolean[adjList.size()];

        dfs(adjList, sourceVertex);
    }

    private void dfs(List<List<Integer>> adjList, int fromV) {
        visited[fromV] = true;

        for (int toV : adjList.get(fromV)) {
            if (!visited[toV]) {
                prev[toV] = fromV;
                dfs(adjList, toV);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public List<Integer> pathTo(int endV) {
        if (!hasPathTo(endV)) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        for (int x = endV; x != sourceVertex; x = prev[x]) {
            path.add(0, x);
        }
        path.add(0, sourceVertex);

        return path;
    }
}
