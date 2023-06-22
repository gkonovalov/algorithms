package com.gkonovalov.datastructures.graphs.representation;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Examples of Adjacency Matrix implementation.
 * An adjacency matrix is a 2D matrix of size VxV, where V is the number of vertices in the graph.
 * The entry at position (i, j) in the matrix indicates whether there is an edge between vertex i
 * and vertex j. For unweighted graphs, the matrix contains 0 or 1. For weighted graphs, the matrix
 * may contain the weight of the edge.
 * The Adjacency Matrix is more efficient and easier to implement for dense graphs
 * with many edges. Checking if an edge exists between two nodes is constant time, O(1).
 * However, the space complexity is O(n^2), which can be inefficient for sparse graphs
 * with few edges. Also, adding or removing a vertex or edge requires copying the entire
 * matrix, which can be expensive for large graphs.
 * </p>
 * Runtime Complexity: O(|V|^2) - and Vertex,
 *                     O(|V|^2) - removing a Vertex,
 *                     O(1) - add Edge,
 *                     O(1) - removing a Edge,
 *                     O(1) - Edge between Vertices (checking for adjacency),
 *                     O(|V|^2) - traversing the graph.
 * Space Complexity:   O(|V|^2).
 */
public class AdjacencyMatrix {

    public boolean[][] getGraphDirected() {
        boolean[][] adjacencyMatrixDirected = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        adjacencyMatrixDirected[0][1] = true;
        adjacencyMatrixDirected[2][1] = true;
        adjacencyMatrixDirected[3][2] = true;

        return adjacencyMatrixDirected;
    }

    public boolean[][] getGraphUndirected() {
        boolean[][] adjacencyMatrixUndirected = new boolean[6][6];

        adjacencyMatrixUndirected[0][1] = true;
        adjacencyMatrixUndirected[1][0] = true;

        adjacencyMatrixUndirected[0][2] = true;
        adjacencyMatrixUndirected[2][0] = true;

        adjacencyMatrixUndirected[2][1] = true;
        adjacencyMatrixUndirected[1][2] = true;

        adjacencyMatrixUndirected[1][3] = true;
        adjacencyMatrixUndirected[3][1] = true;

        adjacencyMatrixUndirected[4][5] = true;
        adjacencyMatrixUndirected[5][4] = true;

        return adjacencyMatrixUndirected;
    }

    public Integer[][] getGraphWeighted() {
        Integer[][] adjacencyMatrixWeighted = new Integer[4][4];

        adjacencyMatrixWeighted[0][1] = 54;
        adjacencyMatrixWeighted[1][0] = 54;

        adjacencyMatrixWeighted[0][3] = 23;
        adjacencyMatrixWeighted[3][0] = 23;

        return adjacencyMatrixWeighted;
    }

    public void printRelationsDfs(boolean[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(adjMatrix, visited, i);
            }
        }
    }

    private void dfs(boolean[][] matrix, boolean[] visited, int startVertex) {
        visited[startVertex] = true;

        for (int toVertex = 0; toVertex < matrix[startVertex].length; toVertex++) {
            if (matrix[startVertex][toVertex]) {
                System.out.println(startVertex + "->" + toVertex);

                if (!visited[toVertex]) {
                    dfs(matrix, visited, toVertex);
                }
            }
        }
    }

    public void printRelationsBfs(boolean[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                bfs(adjMatrix, visited, i);
            }
        }
    }

    private void bfs(boolean[][] matrix, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startVertex);

        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();

            for (int toVertex = 0; toVertex < matrix[fromVertex].length; toVertex++) {
                if (matrix[fromVertex][toVertex]) {
                    System.out.println(fromVertex + "->" + toVertex);

                    if (!visited[fromVertex]) {
                        visited[toVertex] = true;
                        queue.add(toVertex);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix am = new AdjacencyMatrix();
        boolean[][] adjacencyMatrix = am.getGraphDirected();

        System.out.println("Example of DFS algorithm using an Adjacency Matrix:");
        am.printRelationsDfs(adjacencyMatrix);

        System.out.println("Example of BFS algorithm using an Adjacency Matrix:");
        am.printRelationsBfs(adjacencyMatrix);
    }
}
