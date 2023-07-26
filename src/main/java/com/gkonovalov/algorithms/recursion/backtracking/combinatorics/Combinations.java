package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Combinations algorithm implementation. In mathematics and combinatorics, combinations are a way to select
 * a subset of elements from a larger set without considering the order of the selected elements. In other
 * words, combinations represent different ways of choosing elements without arranging them in a specific order.
 * Given a set of distinct items, a combination is a selection of some or all of those items without taking
 * the order into account. For example, if we have a set of elements {1, 2, 3}, some possible combinations
 * are {1, 2}, {1, 3}, {2, 3}, and {1, 2, 3}.
 *
 * The number of combinations for selecting k elements from a set of n distinct elements is denoted as
 * "n choose k" and is represented as C(n, k) or nCk. It is calculated using the binomial coefficient formula:
 * C(n, k) = n! / (k! * (n - k)!)
 *
 * For example:
 * C(4, 2) = 4! / (2! * (4 - 2)!) = 6
 * C(5, 3) = 5! / (3! * (5 - 3)!) = 10
 *
 * As mentioned earlier, combinations are different from permutations. In combinations, the order of the
 * selected elements does not matter, while in permutations, the order does matter. For example, the
 * combinations of {1, 2} are {1, 2} and {2, 1}, while the permutations are {1, 2} and {2, 1} (since the order
 * matters in permutations).
 * </p>
 * Runtime Complexity: O(n! / (k! * (n - k)!)).
 * Space Complexity:   O(k).
 */
public class Combinations {

    public List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    private void backtracking(int n, int k, List<List<Integer>> result, List<Integer> curr, int start) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (Integer num = start; num <= n; num++) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtracking(n, k, result, curr, num + 1);
                curr.remove(num);
            }
        }
    }
}
