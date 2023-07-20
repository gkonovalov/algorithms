package com.gkonovalov.datastructures.graphs.representation;

import com.gkonovalov.datastructures.graphs.EdgeWeighted;

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
 * O(|V|+|E|) - removing a Vertex,
 * O(|E|) - removing a Edge,
 * O(degree(V)) - Edge between Vertices (checking for adjacency),
 * O(|V| + |E|) - traversing the graph.
 * Space Complexity:   O(|V|+|E|), worst case O(|V|^2).
 */
public class AdjacencyList {

    public List<List<Integer>> getGraphUndirected(boolean isHasCycle) {
        List<List<Integer>> adjacencyListUndirected = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            adjacencyListUndirected.add(new ArrayList<>());
        }

        adjacencyListUndirected.get(0).add(1);
        adjacencyListUndirected.get(1).add(0);

        adjacencyListUndirected.get(0).add(2);
        adjacencyListUndirected.get(2).add(0);

        adjacencyListUndirected.get(1).add(3);
        adjacencyListUndirected.get(3).add(1);

        adjacencyListUndirected.get(4).add(5);
        adjacencyListUndirected.get(5).add(4);

        if (isHasCycle) {
            adjacencyListUndirected.get(0).add(3);
            adjacencyListUndirected.get(3).add(0);
        }

        return adjacencyListUndirected;
    }

    public List<List<Integer>> getGraphDirected(boolean isHasCycle) {
        List<List<Integer>> adjacencyListDirected = new LinkedList<>();

        for (int i = 0; i <= 5; i++) {
            adjacencyListDirected.add(new LinkedList<>());
        }

        adjacencyListDirected.get(0).add(1);
        adjacencyListDirected.get(0).add(2);
        adjacencyListDirected.get(1).add(3);
        adjacencyListDirected.get(4).add(5);

        if (isHasCycle) {
            adjacencyListDirected.get(3).add(0);
        }

        return adjacencyListDirected;
    }

    public List<List<Integer>> getGraphBipartiteDirected(boolean isBipartite) {
        List<List<Integer>> adjacencyListDirected = new LinkedList<>();

        for (int i = 0; i <= 3; i++) {
            adjacencyListDirected.add(new LinkedList<>());
        }

        adjacencyListDirected.get(0).add(1);
        adjacencyListDirected.get(1).add(2);
        adjacencyListDirected.get(2).add(3);
        adjacencyListDirected.get(3).add(0);

        if (!isBipartite) {
            adjacencyListDirected.get(0).add(2);
        }

        return adjacencyListDirected;
    }

    public Map<Character, List<Character>> getGraphLabeled() {
        Map<Character, List<Character>> adjacencyListChars = Map.of(
                'a', List.of('b', 'c'),
                'b', List.of('c', 'e'),
                'c', List.of('a', 'b')
        );
        return adjacencyListChars;
    }

    public List<List<EdgeWeighted>> getGraphWeightedUndirected() {
        List<List<EdgeWeighted>> adjListWeighted = new ArrayList<>();
        List<EdgeWeighted> edgeList = new EdgeList().getGraphDirectedWeighted(false);

        for (int i = 0; i < 8; i++) {
            adjListWeighted.add(new ArrayList<>());
        }

        for (EdgeWeighted e : edgeList) {
            adjListWeighted.get(e.fromV).add(new EdgeWeighted(e.fromV, e.toV, e.weight));
            adjListWeighted.get(e.toV).add(new EdgeWeighted(e.toV, e.fromV, e.weight));
        }

        return adjListWeighted;
    }

    public List<List<EdgeWeighted>> getGraphWeightedDirected(boolean isNegative) {
        List<List<EdgeWeighted>> adjListWeighted = new ArrayList<>();
        List<EdgeWeighted> edgeList = new EdgeList().getGraphDirectedWeighted(isNegative);

        for (int i = 0; i < 8; i++) {
            adjListWeighted.add(new ArrayList<>());
        }

        for (EdgeWeighted e : edgeList) {
            adjListWeighted.get(e.fromV).add(e);
        }

        return adjListWeighted;
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
        List<List<Integer>> adjacencyList = al.getGraphUndirected(false);

        System.out.println("Example of DFS algorithm using an Adjacency List:");
        al.printRelationsDfs(adjacencyList);

        System.out.println("Example of BFS algorithm using an Adjacency List:");
        al.printRelationsBfs(adjacencyList);
    }
}
