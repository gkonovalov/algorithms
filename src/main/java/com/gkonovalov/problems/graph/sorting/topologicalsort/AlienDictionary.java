package com.gkonovalov.problems.graph.sorting.topologicalsort;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/alien-dictionary/">
 *          [Hard][269] - Alien Dictionary
 *      </a>
 * </p>
 * Runtime Complexity: O(C) where C total characters across the words, for {@code alienOrder}.
 * Space Complexity:  O(1) because of total 26 characters, for {@code alienOrder}.
 */
public class AlienDictionary {

    public static void main(String[] args) {
        System.out.println("Alien Order:" + alienOrder(new String[]{"z", "z"}));
        System.out.println("Alien Order:" + alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();

        if (!buildGraph(words, graph)) {
            return "";
        }

        return topologicalSort(graph);
    }

    private static boolean buildGraph(String[] words, Map<Character, List<Character>> graph) {
        for (String word : words) {
            for (Character letter : word.toCharArray()) {
                graph.put(letter, new ArrayList<>());
            }
        }

        for (int k = 1; k < words.length; k++) {
            String first = words[k - 1];
            String second = words[k];

            if (first.length() > second.length() && first.startsWith(second)) {
                return false;
            }

            for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
                char a = first.charAt(i);
                char b = second.charAt(i);

                if (a != b) {
                    graph.get(a).add(b);
                    break;
                }
            }
        }
        return true;
    }

    private static String topologicalSort(Map<Character, List<Character>> graph) {
        boolean[] visited = new boolean[26];
        boolean[] visitedOnStack = new boolean[26];
        StringBuffer reversePostOrder = new StringBuffer();

        for (Character v : graph.keySet()) {
            if (hasCycle(graph, reversePostOrder, visited, visitedOnStack, v)) {
                return "";
            }
        }

        return reversePostOrder.toString();
    }

    private static boolean hasCycle(Map<Character, List<Character>> graph,
                                    StringBuffer reversePostOrder,
                                    boolean[] visited,
                                    boolean[] visitedOnStack,
                                    Character fromV) {
        if (visitedOnStack[fromV - 'a']) {
            return true;
        }

        if (visited[fromV - 'a']) {
            return false;
        }

        visited[fromV - 'a'] = true;
        visitedOnStack[fromV - 'a'] = true;

        for (Character toV : graph.get(fromV)) {
            if (hasCycle(graph, reversePostOrder, visited, visitedOnStack, toV)) {
                return true;
            }
        }

        visitedOnStack[fromV - 'a'] = false;
        reversePostOrder.insert(0, fromV);

        return false;
    }
}
