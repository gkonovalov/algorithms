package com.gkonovalov.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph construction.
 * The Graph Node based on Adjacency List representation which is more efficient than the
 * djacency Matrix, especially for sparse graphs. Traversing the graph takes O(|V| + |E|) time
 * complexity. Also, adding or removing a Vertex or Edge is simpler and less expensive than with
 * an Adjacency Matrix. However, checking if an Edge exists between two nodes takes O(degree(V))
 * time complexity which slower than with Adjacency Matrix.
 *
 * A graph is a data structure that consists of a set of vertices (also known as nodes or points)
 * connected by edges. It is a fundamental concept in computer science and mathematics, used to
 * represent relationships between objects or entities. There are several common representations
 * of graphs, each with its own advantages and disadvantages. The choice of representation depends
 * on factors such as the size of the graph, the type of operations to be performed, and the space
 * and time complexity requirements.
 * Here are some commonly used representations of graphs:
 * Adjacency Matrix, Adjacency List, Edge List.
 *
 * Graphs can be classified into various types based on their characteristics and properties.
 * Here are some common types of graphs:
 * Directed Graph, Undirected Graph, Weighted Graph, Unweighted Graph, Cyclic Graph, Acyclic Graph,
 * Labeled Graph, Infinite Graph, Bipartite Graph, Directed Acyclic Graph (DAG), Tree, Forest.
 * </p>
 * Runtime Complexity: O(1) - add Edge and add Vertex,
 *                     O(|V|+|E|) - removing a Vertex,
 *                     O(|E|) - removing a Edge,
 *                     O(degree(V)) - Edge between Vertices (checking for adjacency),
 *                     O(|V| + |E|) - traversing the graph.
 * Space Complexity:   O(|V|+|E|), worst case O(|V|^2).
 */
public class Graph {

    private final int V;
    private int E;
    private List<List<Integer>> adjList;

    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }

        this.V = V;
        this.E = 0;
        this.adjList = new ArrayList<>();

        for (int v = 0; v < V; v++) {
            adjList.add(new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adjList.get(v).contains(w);
    }

    public int degree(int v) {
        validateVertex(v);
        return adjList.get(v).size();
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adjList.get(v);
    }
}
