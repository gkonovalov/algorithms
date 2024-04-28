package com.gkonovalov.problems.greedy;

import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 4/27/2024.
 * <p>
 * The Greedy Knapsack algorithm is a heuristic approach to solving the Knapsack problem.
 * It aims to maximize the total value of items selected for the knapsack while ensuring that
 * the total weight does not exceed a certain capacity.
 *
 * The Greedy Knapsack algorithm iteratively selects items based on a greedy criterion, typically
 * the value-to-weight ratio, without considering future consequences.
 * Unlike the classic 0/1 Knapsack problem, where items cannot be duplicated, the Greedy Knapsack
 * algorithm does not strictly enforce this constraint, potentially leading to suboptimal solutions.
 * Although efficient, the Greedy Knapsack algorithm does not always guarantee an optimal solution.
 * However, it can be a practical choice for certain scenarios with large datasets where an exact
 * solution is not required.
 *
 * Formally, the problem can be stated as follows:
 *
 * Given:
 * A set of items, each with a weight and a value.
 * A knapsack with a maximum weight capacity.
 *
 * Find:
 * The most valuable combination of items that can be placed in the knapsack without exceeding its
 * weight capacity, using a greedy selection strategy.
 * </p>
 * Runtime Complexity: O(n log n) for {@code knapsack}.
 * Space Complexity:   O(1) for {@code knapsack}.
 */
public class Knapsack {

    public static void main(String[] args) {
        Item[] items = {
                new Item(1, 5),
                new Item(2, 4),
                new Item(4, 8),
                new Item(5, 6)
        };
        int capacity = 7;

        System.out.println("Maximum value:" + knapsack(items, capacity));
    }

    public static int knapsack(Item[] items, int capacity) {
        Arrays.sort(items, (o1, o2) -> o2.ratio - o1.ratio);

        int currentWeight = 0;
        int finalValue = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                finalValue += item.value;
            } else {
                int remainingCapacity = capacity - currentWeight;

                finalValue += remainingCapacity / item.weight * item.value;
                break;
            }
        }

        return finalValue;
    }

    static class Item {
        public int value;
        public int weight;
        public int ratio;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = value / weight;
        }
    }
}
