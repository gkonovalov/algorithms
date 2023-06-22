package com.gkonovalov.datastructures.graphs.representation;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Examples of Edge List implementations.
 * An edge list representation stores the edges of the graph as individual objects in a list or an array.
 * Each edge object typically contains the source vertex, destination vertex, and possibly the weight or any
 * other edge attributes. This representation is straightforward and efficient for certain graph algorithms,
 * such as Kruskal's algorithm for minimum spanning trees.
 * The Edge List only stores information about the edges, while the Adjacency List
 * stores information about the vertices and their connections.
 * In the Edge List each edge is a pair of vertices (u, v), indicating that there is an edge
 * from u to v in the graph.
 * </p>
 * Runtime Complexity: O(1) - add Edge and add Vertex,
 *                     O(|E|) - removing a Vertex,
 *                     O(|E|) - removing a Edge,
 *                     O(|E|) - Edge between Vertices (checking for adjacency),
 *                     O(|V| + |E|) - traversing the graph.
 * Space Complexity:   O(|E|).
 */
public class EdgeList {

    public List<List<Integer>> getGraphDirected() {
        List<List<Integer>> edgeList = List.of(
                List.of(0, 1),
                List.of(2, 5)
        );
        return edgeList;
    }

    public List<List<Integer>> getGraphUndirected() {
        List<List<Integer>> edgeList = List.of(
                List.of(0, 1),
                List.of(1, 0)
        );
        return edgeList;
    }

    public List<List<Integer>> getGraphWeighted() {
        List<List<Integer>> edgeList = List.of(
                List.of(0, 1, 200),
                List.of(2, 5, 300)
        );
        return edgeList;
    }

    public void printEdges(List<List<Integer>> edgeList) {
        for (List<Integer> edge : edgeList) {
            System.out.println(edge.get(0) + "->" + edge.get(1));
        }
    }

    public static void main(String[] args) {
        EdgeList el = new EdgeList();
        List<List<Integer>> edgeList = el.getGraphDirected();

        System.out.println("Print all Edges from Edge List:");
        el.printEdges(edgeList);
    }
}
