package com.gkonovalov.problems.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/combinations/">
 *          [Medium][77] - Combinations
 *      </a>
 * </p>
 * Runtime Complexity: O(n! / (k! * (n - k)!)).
 * Space Complexity:   O(k).
 */
public class Combinations {

    public static void main(String[] args) {
        combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> curr, int n, int k, int start) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int num = start; num <= n; num++) {
            curr.add(num);
            backtracking(result, curr, n, k, num + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
