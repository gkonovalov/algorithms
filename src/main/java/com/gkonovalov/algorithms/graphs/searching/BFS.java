package com.gkonovalov.algorithms.graphs.searching;

import com.gkonovalov.datastructures.graphs.GraphNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 17/06/2023.
 * <p>
 * Breadth First Search implementation. BFS stands for Breadth-First Search. It is a graph
 * traversal algorithm that explores all the vertices of a graph or all the nodes of a tree in
 * breadth-first order, i.e., it visits all the nodes at the same level (Level-order traversal)
 * before moving to the next level.
 * BFS guarantees that all nodes reachable from the source node will be visited, and the algorithm
 * visits nodes in increasing order of their distance from the source node.
 *
 * The algorithm can be used for finding the shortest path between two vertices, counting connected
 * components, checking bipartiteness, or exploring a graph level by level. It is particularly useful
 * for web crawling, as it allows indexing pages without going too deep, thereby avoiding excessive
 * resource usage.
 *
 * BFS typically requires more memory compared to DFS, as it needs to maintain a queue of nodes to visit.
 * It' can be less memory efficient when dealing with large trees that have a wide width. In situations
 * where the solution is likely to be near the root of the tree, a breadth-first search (BFS) may be more
 * efficient. However, if the tree is very deep and solutions are rare, a depth-first search (DFS) might
 * take an excessively long time, while BFS could provide faster results (ex. Web Crawler).
 * BFS is particularly useful when the depth of the tree can vary or when a single answer is needed, such
 * as finding the shortest path in a maze. BFS performs better in this scenario because DFS is more likely
 * to explore a significant portion of the maze before reaching the goal, potentially wasting time.
 * </p>
 * Runtime Complexity: O(V+E) {@code searchInAdjList}, {@code searchInGraphNode}, {@code searchInMatrix}.
 * Space Complexity: O(V).
 */
public class BFS {

    public boolean searchInAdjList(List<List<Integer>> adjacencyList, int findVertex) {
        int numVertices = adjacencyList.size();
        boolean[] visited = new boolean[numVertices];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(findVertex);

        while (!queue.isEmpty()) {
            Integer fromVertex = queue.poll();

            if (fromVertex.equals(findVertex)) {
                return true;
            }

            for (Integer toVertex : adjacencyList.get(findVertex)) {
                if (!visited[toVertex]) {
                    visited[toVertex] = true;
                    queue.add(toVertex);
                }
            }
        }
        return false;
    }

    public boolean searchInGraphNode(GraphNode<Integer> node, int findVertex) {
        node.visited = true;

        Queue<GraphNode<Integer>> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode<Integer> fromVertex = queue.poll();

            if (fromVertex.value.equals(findVertex)) {
                return true;
            }

            for (GraphNode<Integer> toVertex : fromVertex.neighbors) {
                if (!toVertex.visited) {
                    toVertex.visited = true;
                    queue.add(toVertex);
                }
            }
        }
        return false;
    }

    public boolean searchInMatrix(int[][] adjMatrix, int startVertex, int findVertex) {
        int numVertices = adjMatrix.length;
        boolean[] visited = new boolean[numVertices];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startVertex);

        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();

            if (fromVertex == findVertex) {
                return true;
            }

            for (int toVertex = 0; toVertex < numVertices; toVertex++) {
                if (!visited[toVertex] && adjMatrix[fromVertex][toVertex] == 1) {
                    visited[toVertex] = true;
                    queue.add(toVertex);
                }
            }
        }
        return false;
    }
}
