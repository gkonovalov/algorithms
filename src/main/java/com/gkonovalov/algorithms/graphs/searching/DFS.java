package com.gkonovalov.algorithms.graphs.searching;

import com.gkonovalov.datastructures.graphs.representation.GraphNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Depth First Search implementation. DFS stands for Depth-First Search. It is an algorithm used
 * to traverse or search through a graph or tree data structure. DFS explores a path as deeply
 * as possible before backtracking and exploring other paths. DFS can be implemented using either
 * a recursive approach or an iterative approach with the help of a stack data structure to keep
 * track of nodes to be visited. DFS search is not well-suited for computing the shortest path,
 * but it excels in aggressive exploration, similar to navigating through a maze. It can also be
 * used to count connected components and topological sorting.
 * However, if the graph or tree is deep and solutions are rare, DFS might take a long time,
 * whereas BFS could be faster. On the other hand, if the tree is wide, DFS can significantly reduce
 * memory usage compared to BFS. Additionally, when it is known beforehand that the desired answer
 * is likely to be found deep within the tree, DFS is a better option than BFS.
 * </p>
 * Runtime Complexity: O(V+E) {@code dfsExample}, {@code pathRecursive},
 *                            {@code searchRecursive}, {@code searchPreorderIterative}.
 * Space Complexity: O(V).
 */
public class DFS {

    private void dfsExample(GraphNode<Integer> graphNode) {
        graphNode.visited = true;

        for (GraphNode<Integer> toVertex : graphNode.neighbors) {
            if (!toVertex.visited) {
                dfsExample(toVertex);
            }
        }
    }

    public List<Integer> pathRecursive(List<List<Integer>> adjList,
                              int startVertex,
                              int findVertex) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];

        pathRecursive(adjList, path, visited, startVertex, findVertex);

        return path;
    }

    private boolean pathRecursive(List<List<Integer>> adjList,
                                  List<Integer> path,
                                  boolean[] visited,
                                  int fromVertex,
                                  int findVertex) {
        path.add(fromVertex);

        if (fromVertex == findVertex) {
            return true;
        }

        visited[fromVertex] = true;

        for (Integer toVertex : adjList.get(fromVertex)) {
            if (!visited[toVertex] &&
                    pathRecursive(adjList, path, visited, toVertex, findVertex)) {
                return true;
            }
        }

        path.remove(fromVertex);
        return false;
    }

    public boolean searchRecursive(List<List<Integer>> adjList,
                                   int startVertex,
                                   int findVertex) {
        boolean[] visited = new boolean[adjList.size()];

        return searchRecursive(adjList, visited, startVertex, findVertex);
    }

    private boolean searchRecursive(List<List<Integer>> adjList,
                                    boolean[] visited,
                                    int fromVertex,
                                    int findVertex) {
        if (fromVertex == findVertex) {
            return true;
        }

        visited[fromVertex] = true;

        for (Integer toVertex : adjList.get(fromVertex)) {
            if (!visited[toVertex] &&
                    searchRecursive(adjList, visited, toVertex, findVertex)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchRecursive(int[][] adjMatrix,
                                   int startVertex,
                                   int findVertex) {
        boolean[] visited = new boolean[adjMatrix.length];

        return searchRecursive(adjMatrix, visited, startVertex, findVertex);
    }

    private boolean searchRecursive(int[][] adjMatrix,
                                    boolean[] visited,
                                    int fromVertex,
                                    int findVertex) {
        if (fromVertex == findVertex) {
            return true;
        }

        visited[fromVertex] = true;

        for (int toVertex = 0; toVertex < adjMatrix[fromVertex].length; toVertex++) {
            if (!visited[toVertex] &&
                    adjMatrix[fromVertex][toVertex] == 1 &&
                    searchRecursive(adjMatrix, visited, toVertex, findVertex)) {
                return true;
            }
        }

        return false;
    }

    public boolean searchPreorderIterative(List<List<Integer>> adjList,
                                           int startVertex,
                                           int findVertex) {
        boolean[] visited = new boolean[adjList.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer fromVertex = stack.pop();

            if (fromVertex == findVertex) {
                return true;
            }

            for (Integer toVertex : adjList.get(fromVertex)) {
                if (!visited[toVertex]) {
                    visited[toVertex] = true;
                    stack.push(toVertex);
                }
            }
        }
        return false;
    }
}
