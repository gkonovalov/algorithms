package com.gkonovalov.datastructures.graphs.representation;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Examples of Adjacency List implementation.
 * An adjacency list represents a graph as an array of lists or linked lists.
 * Each vertex in the graph has an associated list that stores its neighboring vertices.
 * For unweighted graphs, the lists contain the adjacent vertices. For weighted graphs,
 * the lists may contain the adjacent vertices along with their corresponding edge weights.
 * Sparse graphs with fewer edges are well-suited for this representation, as it saves space.
 * The Adjacency List representation is more efficient than the Adjacency Matrix,
 * especially for sparse graphs. Traversing the graph takes O(|V| + |E|) time complexity.
 * Also, adding or removing a Vertex or Edge is simpler and less expensive
 * than with an Adjacency Matrix. However, checking if an Edge exists between two nodes
 * takes O(degree(V)) time complexity which slower than with Adjacency Matrix.
 * </p>
 * Runtime Complexity: O(1) - add Edge and add Vertex,
 *                     O(|V|+|E|) - removing a Vertex,
 *                     O(|E|) - removing a Edge,
 *                     O(degree(V)) - Edge between Vertices (checking for adjacency),
 *                     O(|V| + |E|) - traversing the graph.
 * Space Complexity:   O(|V|+|E|), worst case O(|V|^2).
 */
public class AdjacencyList {

    public List<List<Integer>> getAdjacencyListUndirected() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2),
                List.of(0, 2, 3),
                List.of(0, 1),
                List.of(1),
                List.of(5),
                List.of(4)
        );
        return adjacencyList;
    }

    public Map<Character, List<Character>> getAdjacencyListChars() {
        Map<Character, List<Character>> adjacencyListChars = Map.of(
                'a', List.of('b', 'c'),
                'b', List.of('c', 'e'),
                'c', List.of('a', 'b')
        );
        return adjacencyListChars;
    }

    public List<List<Integer>> getAdjacencyListDirected() {
        List<List<Integer>> adjacencyListDirected = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            adjacencyListDirected.add(new LinkedList<>());
        }

        adjacencyListDirected.get(1).add(0);
        adjacencyListDirected.get(2).add(3);

        return adjacencyListDirected;
    }

    public List<List<List<Integer>>> getAdjacencyListWeighted() {
        List<List<List<Integer>>> adjacencyListWeighted = Arrays.asList(
                List.of(List.of(1, 65), List.of(1, 43)),
                List.of(List.of(0, 56), List.of(2, 22), List.of(3, 67)),
                List.of(List.of(2, 23), List.of(3, 65)),
                List.of(List.of(3, 78), List.of(3, 34))
        );

        return adjacencyListWeighted;
    }

    public void printRelationsDfs(List<List<Integer>> adjacencyList) {
        int numVertices = adjacencyList.size();
        boolean[] visited = new boolean[numVertices];

        for (int startVertex = 0; startVertex < numVertices; startVertex++) {
            if (!visited[startVertex]) {
                dfs(adjacencyList, visited, startVertex);
            }
        }
    }

    private void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int startVertex) {
        visited[startVertex] = true;

        for (Integer vertexTo : adjacencyList.get(startVertex)) {
            System.out.println(startVertex + "->" + vertexTo);

            if (!visited[vertexTo]) {
                dfs(adjacencyList, visited, vertexTo);
            }
        }
    }

    public void printRelationsBfs(List<List<Integer>> adjacencyList) {
        int numVertices = adjacencyList.size();
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                bfs(adjacencyList, visited, i);
            }
        }
    }

    public void bfs(List<List<Integer>> adjacencyList, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            Integer vertexFrom = queue.poll();

            for (Integer vertexTo : adjacencyList.get(vertexFrom)) {
                System.out.println(vertexFrom + "->" + vertexTo);

                if (!visited[vertexTo]) {
                    visited[vertexTo] = true;
                    queue.add(vertexTo);
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyList al = new AdjacencyList();
        List<List<Integer>> adjacencyList = al.getAdjacencyListUndirected();

        System.out.println("Example of DFS algorithm using an Adjacency List:");
        al.printRelationsDfs(adjacencyList);

        System.out.println("Example of BFS algorithm using an Adjacency List:");
        al.printRelationsBfs(adjacencyList);
    }
}
