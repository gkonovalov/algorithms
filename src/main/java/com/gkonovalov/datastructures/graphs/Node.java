package com.gkonovalov.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 18/06/2023.
 * <p>
 * Base block for the Graph construction.
 *
 * The Graph Node based on Adjacency List representation which is more efficient than the Adjacency Matrix,
 * especially for sparse graphs. Traversing the graph takes O(|V| + |E|) time complexity. Also, adding or
 * removing a Vertex or Edge is simpler and less expensive than with an Adjacency Matrix. However, checking
 * if an Edge exists between two nodes takes O(degree(V)) time complexity which slower than with Adjacency Matrix.
 * </p>
 * Runtime Complexity: O(1) - add Edge and add Vertex,
 *                     O(|V|+|E|) - removing a Vertex,
 *                     O(|E|) - removing a Edge,
 *                     O(degree(V)) - Edge between Vertices (checking for adjacency),
 *                     O(|V| + |E|) - traversing the graph.
 * Space Complexity:   O(|V|+|E|), worst case O(|V|^2).
 */
public class Node<T> {
    public T value;
    public List<Node<T>> neighbors;
    public boolean visited;

    public Node() {
        this.visited = false;
        this.neighbors = new ArrayList<>();
    }
}
