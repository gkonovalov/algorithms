package com.gkonovalov.algorithms.graphs.searching.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Implementation of Depth First Search(Path). DFS stands for Depth-First Search. It is an algorithm used
 * to traverse or search through a graph or tree data structure. DFS explores a path as deeply
 * as possible before backtracking and exploring other paths. DFS can be implemented using either
 * a recursive approach or an iterative approach with the help of a stack data structure to keep
 * track of nodes to be visited. DFS search is not well-suited for computing the shortest path,
 * but it excels in aggressive exploration, similar to navigating through a maze. It can also be
 * used to count connected components and topological sorting.
 *
 * The memory is taken by DFS or BFS heavily depends on the structure of your tree. The maximum memory
 * taken by DFS (i.e., by call stack) is equal to the depth of the tree, and the maximum memory taken by BFS
 * is equal to the width of the tree.
 * If our tree is wide, use DFS as BFS will take too much memory. Similarly, if our tree is very deep,
 * choose BFS over DFS.
 * If we know the solution is not that far from the source vertex in deep tree, use BFS.
 * If we know the solution lies far from the source vertex in wide tree, use DFS.
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

        Arrays.fill(prev, -1);

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
        return prev[v] != -1;
    }

    public List<Integer> pathTo(int endV) {
        if (!hasPathTo(endV)) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = endV; v != sourceVertex; v = prev[v]) {
            path.add(0, v);
        }
        path.add(0, sourceVertex);

        return path;
    }
}
