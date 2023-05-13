package com.gkonovalov.datastructures.graphs.representation;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Examples of AdjacencyList implementation. Adjacency List is a more
 * storage-efficient method for graph representation.
 * </p>
 * Runtime Complexity: O(1) - add Edge and add Vertex;
 *                     O(|V|+|E|) - removing a Vertex;
 *                     O(|E|) - removing a Edge;
 *                     O(|V|) - finding neighbors;
 *                     O(|V| + |E|) - traversing the graph.
 * Space Complexity: O(|V|+|E|), worst case O(V^2).
 */
public class AdjacencyList {

    public List<List<Integer>> getAdjacencyList() {
        List<List<Integer>> adjacencyList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(0, 2, 3),
                Arrays.asList(0, 1),
                Arrays.asList(1, 3)
        );
        return adjacencyList;
    }

    public Map<Character, List<Character>> getAdjacencyListChars() {
        Map<Character, List<Character>> adjacencyListStrings = new HashMap<>() {{
            put('a', new LinkedList<>() {{
                add('b');
                add('c');
            }});
            put('b', new LinkedList<>() {{
                add('c');
                add('e');
            }});
            put('c', new LinkedList<>() {{
                add('a');
                add('b');
            }});
        }};
        return adjacencyListStrings;
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

    public List<List<Integer>> getAdjacencyListUndirected() {
        List<List<Integer>> adjacencyListUndirected = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            adjacencyListUndirected.add(new LinkedList<>());
        }

        adjacencyListUndirected.get(1).add(0);
        adjacencyListUndirected.get(0).add(1);

        adjacencyListUndirected.get(2).add(3);
        adjacencyListUndirected.get(3).add(2);

        return adjacencyListUndirected;
    }

    public List<List<Integer[]>> getAdjacencyListWeighted() {
        List<List<Integer[]>> adjacencyListWeighted = Arrays.asList(
                Arrays.asList(new Integer[]{1, 65}, new Integer[]{1, 43}),
                Arrays.asList(new Integer[]{0, 56}, new Integer[]{2, 22}, new Integer[]{3, 67}),
                Arrays.asList(new Integer[]{2, 23}, new Integer[]{3, 65}),
                Arrays.asList(new Integer[]{3, 78}, new Integer[]{3, 34})
        );

        return adjacencyListWeighted;
    }
}
