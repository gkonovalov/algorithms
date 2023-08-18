package com.gkonovalov.problems.recursion.dp;

/**
 * Created by Georgiy Konovalov on 15/08/2023.
 * <p>
 * The Unbounded Knapsack problem is a variation of the classic Knapsack problem.
 * It's a combinatorial problem that deals with a scenario where you have a set of items, each with
 * a weight and a value, and you want to select a subset of these items to maximize the total value
 * while ensuring that the total weight does not exceed a certain capacity.
 * The Unbounded Knapsack problem is a more relaxed version of the classic 0/1 Knapsack problem, where
 * you are limited to including each item at most once. The relaxation of this constraint makes the
 * problem a bit easier to solve since you can repeatedly add the same item as long as the knapsack's
 * capacity allows.
 * Formally, the problem can be stated as follows:
 *
 * Given:
 * A set of items, each with a weight and a value.
 * A knapsack with a maximum weight capacity.
 *
 * Find:
 * The most valuable combination of items that can be placed in the knapsack without exceeding its
 * weight capacity.
 * </p>
 * Runtime Complexity: O(n^w) for {@code knapsackDPUnbounded},
 *                     O(2^n) for {@code knapsackRecursiveUnbounded}.
 * Space Complexity:   O(w) for {@code knapsackDPUnbounded},
 *                     O(n) for {@code knapsackRecursiveUnbounded}.
 */
public class KnapsackUnbounded {

    public static void main(String[] args) {
        int[] weights = {1, 2, 4, 5};
        int[] values = {5, 4, 8, 6};
        int capacity = 7;

        System.out.println("Knapsack Recursive Unbounded:" + knapsackRecursiveUnbounded(weights, values, capacity, values.length));
        System.out.println("Knapsack DP Unbounded:" + knapsackDPUnbounded(weights, values, capacity));
    }

    public static int knapsackDPUnbounded(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for (int w = 0; w <= capacity; w++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                }
            }
        }

        return dp[capacity];
    }

    public static int knapsackRecursiveUnbounded(int[] weights, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (weights[n - 1] > capacity) {
            return knapsackRecursiveUnbounded(weights, values, capacity, n - 1);
        }

        return Math.max(
                values[n - 1] + knapsackRecursiveUnbounded(weights, values, capacity - weights[n - 1], n),
                knapsackRecursiveUnbounded(weights, values, capacity, n - 1)
        );
    }
}
