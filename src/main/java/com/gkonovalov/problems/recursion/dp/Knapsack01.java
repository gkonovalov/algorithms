package com.gkonovalov.problems.recursion.dp;

/**
 * Created by Georgiy Konovalov on 15/08/2023.
 * <p>
 * The 0/1 Knapsack problem is a classic optimization problem in computer science and mathematics.
 * It's a combinatorial problem that deals with a scenario where you have a set of items, each with
 * a weight and a value, and you want to select a subset of these items to maximize the total value
 * while ensuring that the total weight does not exceed a certain capacity.
 * The "0/1" in the problem name refers to the constraint that you can either include an item in the
 * knapsack (value of 1) or exclude it (value of 0), but you cannot include a fraction of an item.
 * Formally, the problem can be stated as follows:
 *
 * Given:
 * A set of items, each with a weight and a value.
 * A knapsack with a maximum weight capacity.
 *
 * Find:
 * The most valuable combination of items that can be placed in the knapsack without exceeding its
 * weight capacity.
 *
 * The 0/1 Knapsack problem is NP-hard, meaning that there is no known polynomial-time algorithm
 * that can solve it for all cases. However, dynamic programming provides an efficient way to solve
 * it in pseudo-polynomial time, especially when the number of items and the knapsack capacity are
 * not too large.
 * </p>
 * Runtime Complexity: O(n w) for {@code knapsack}, {@code knapsack2},
 *                     O(2^n) for {@code knapsackRecursive}.
 * Space Complexity:   O(n w) for {@code knapsack},
 *                     O(w) for {@code knapsack2},
 *                     O(n) for {@code knapsackRecursive}.
 */
public class Knapsack01 {

    public static void main(String[] args) {
        int[] weights = {1, 2, 4, 5};
        int[] values = {5, 4, 8, 6};
        int capacity = 7;

        System.out.println("Maximum value:" + knapsackDP(weights, values, capacity));
        System.out.println("Maximum value:" + knapsackDP2(weights, values, capacity));
        System.out.println("Maximum value:" + knapsackRecursive(weights, values, capacity, values.length));
    }

    public static int knapsackDP(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = capacity; w >= 0; w--) {
                if (weights[i - 1] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[capacity];
    }

    public static int knapsackDP2(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        return dp[n][capacity];
    }

    public static int knapsackRecursive(int[] weights, int[] values, int capacity, int n) {
        if (n <= 0 || capacity <= 0) {
            return 0;
        }

        if (weights[n - 1] > capacity) {
            return knapsackRecursive(weights, values, capacity, n - 1);
        }

        return Math.max(
                values[n - 1] + knapsackRecursive(weights, values, capacity - weights[n - 1], n - 1),
                knapsackRecursive(weights, values, capacity, n - 1)
        );
    }
}
