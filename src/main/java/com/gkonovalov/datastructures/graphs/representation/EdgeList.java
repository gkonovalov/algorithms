package com.gkonovalov.datastructures.graphs.representation;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
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
 * Space Complexity:   O(|V|+|E|).
 */
public class EdgeList {

    public List<List<Integer>> getEdgeListDirected() {
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0, 1));
        edgeList.add(Arrays.asList(2, 5));

        return edgeList;
    }

    public List<List<Integer>> getEdgeListUndirected() {
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0, 1));
        edgeList.add(Arrays.asList(1, 0));

        return edgeList;
    }

    public List<List<Integer>> getEdgeListWeighted() {
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0, 1, 300));
        edgeList.add(Arrays.asList(2, 5, 150));

        return edgeList;
    }

    public void printEdges(List<List<Integer>> edgeList) {
        for (List<Integer> edge : edgeList) {
            System.out.println(edge.get(0) + "->" + edge.get(1));
        }
    }

    public static void main(String[] args) {
        EdgeList el = new EdgeList();
        List<List<Integer>> edgeList = el.getEdgeListDirected();

        System.out.println("Print all Edges from Edge List:");
        el.printEdges(edgeList);
    }
}
