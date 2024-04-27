package com.gkonovalov.problems.recursion.backtracking;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 4/26/2024.
 * <p>
 * The Traveling Salesman Problem (TSP) is a classic optimization problem in computer science and mathematics.
 * It's a combinatorial problem that deals with finding the shortest possible route that visits each
 * of a given set of cities exactly once and returns to the starting city, where the distance between
 * each pair of cities is known.
 * Formally, the problem can be stated as follows:
 *
 * Given:
 * A graph and the distances between each pair of cities.
 *
 * Find:
 * The shortest possible route that visits each city exactly once and returns to the starting city.
 *
 * The brute force approach to solving the Traveling Salesman Problem involves generating all possible
 * permutations of cities, calculating the total distance for each permutation, and selecting the one
 * with the minimum total distance. While this approach guarantees an optimal solution, it becomes
 * impractical for large datasets due to its exponential time complexity.
 * </p>
 * Runtime Complexity: O(n!) for {@code solveTSP}.
 * Space Complexity:   O(n) for {@code solveTSP}.
 */

public class TravelingSalesmanProblem {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 29, 20, 21},
                {29, 0, 15, 14},
                {20, 15, 0, 4},
                {21, 14, 4, 0}
        };

        System.out.println("Minimum distance for TSP: " + solveTSP(graph));
    }

    public static int solveTSP(int[][] graph) {
        List<int[]> permutations = new ArrayList<>();

        int[] path = new int[graph.length];
        for (int i = 0; i < path.length; i++) {
            path[i] = i;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);  // Starting from city 0

        generatePermutations(path, 0, graph, visited, permutations);

        int minCost = Integer.MAX_VALUE;

        for (int[] permutation : permutations) {
            minCost = Math.min(minCost, calculateCost(permutation, graph));
        }

        return minCost;
    }

    private static void generatePermutations(int[] path, int index, int[][] graph, Set<Integer> visited, List<int[]> permutations) {
        if (index == path.length - 1) {
            permutations.add(path.clone());
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(i)) {
                path[index + 1] = i;

                visited.add(i);
                generatePermutations(path, index + 1, graph, visited, permutations);
                visited.remove(i);
            }
        }
    }

    private static int calculateCost(int[] path, int[][] graph) {
        int cost = 0;

        for (int i = 0; i < path.length - 1; i++) {
            cost += graph[path[i]][path[i + 1]];
        }

        cost += graph[path[path.length - 1]][path[0]];

        return cost;
    }
}

