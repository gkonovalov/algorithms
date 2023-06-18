package com.gkonovalov.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph construction.
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
 *
 * The Graph Node based on Adjacency List representation which is more efficient than the
 * Adjacency Matrix, especially for sparse graphs. Traversing the graph takes O(|V| + |E|) time
 * complexity. Also, adding or removing a Vertex or Edge is simpler and less expensive than with
 * an Adjacency Matrix. However, checking if an Edge exists between two nodes takes O(degree(V))
 * time complexity which slower than with Adjacency Matrix.
 * </p>
 * Runtime Complexity: O(1) - add Edge and add Vertex,
 *                     O(|V|+|E|) - removing a Vertex,
 *                     O(|E|) - removing a Edge,
 *                     O(degree(V)) - Edge between Vertices (checking for adjacency),
 *                     O(|V| + |E|) - traversing the graph.
 * Space Complexity:   O(|V|+|E|), worst case O(|V|^2).
 */
public class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> neighbors;
    public boolean visited;

    public GraphNode() {
        this.visited = false;
        this.neighbors = new ArrayList<>();
    }
}
