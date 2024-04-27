package com.gkonovalov.problems.recursion.dp;

import java.util.Arrays;
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
 * A set of cities and the distances between each pair of cities.
 *
 * Find:
 * The shortest possible route that visits each city exactly once and returns to the starting city.
 *
 * The Traveling Salesman Problem is NP-hard, meaning that there is no known polynomial-time algorithm
 * that can solve it for all cases. However, various algorithms exist to find approximate solutions
 * in polynomial time, such as brute force, dynamic programming, and heuristic methods like nearest
 * neighbor and genetic algorithms.
 * </p>
 * Runtime Complexity: O(n^2 * 2^n) for {@code solveTSP}.
 * Space Complexity:   O(n * 2^n) for {@code solveTSP}.
 */

public class TravelingSalesmanProblem {

    public static void main(String[] args) {
        double[][] graph = {
                {0,  29, 20, 21},
                {29,  0, 15, 14},
                {20, 15,  0,  4},
                {21, 14,  4,  0}
        };

        System.out.println("Minimum distance for TSP: " + solveTSP(graph));
    }

    public static double solveTSP(double[][] distances) {
        int numCities = distances.length;
        int numSets = 1 << numCities;
        double[][] dp = new double[numSets][numCities];

        for (int i = 0; i < numSets; i++) {
            Arrays.fill(dp[i], Double.POSITIVE_INFINITY);
        }

        dp[1][0] = 0; // Starting from city 0

        for (int mask = 1; mask < numSets; mask += 2) {
            for (int u = 1; u < numCities; u++) {
                if ((mask & (1 << u)) != 0) {
                    for (int v = 0; v < numCities; v++) {
                        if ((mask & (1 << v)) != 0) {
                            dp[mask][u] = Math.min(dp[mask][u], dp[mask ^ (1 << u)][v] + distances[v][u]);
                        }
                    }
                }
            }
        }

        double minDistance = Double.POSITIVE_INFINITY;
        int allCitiesMask = (1 << numCities) - 1;

        for (int u = 1; u < numCities; u++) {
            minDistance = Math.min(minDistance, dp[allCitiesMask][u] + distances[u][0]);
        }

        return minDistance;
    }
}
