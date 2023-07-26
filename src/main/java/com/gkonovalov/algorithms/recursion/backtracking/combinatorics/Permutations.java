package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Permutations algorithm implementation. In mathematics and combinatorics, a permutation is an arrangement
 * or ordering of a set of elements. Given a set of distinct items, a permutation is a specific way of
 * rearranging these items in a specific order. For example, if we have a set of elements {1, 2, 3}, some
 * possible permutations are {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, and so on.
 * The number of permutations for a set of n distinct elements is denoted by n!, read as "n factorial."
 * The factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
 * It is defined as: n! = n * (n - 1) * (n - 2) * ... * 2 * 1
 * Permutations are different from combinations. In permutations, the order of the elements matters, while in
 * combinations, the order does not matter. For example, the permutations of {1, 2} are {1, 2} and {2, 1}, but
 * the combinations are only {1, 2} (since the order {2, 1} is considered the same as {1, 2}).
 * </p>
 * Runtime Complexity: O(!n).
 * Space Complexity:   O(n).
 */
public class Permutations {

    public List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (Integer num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtracking(nums, result, curr);
                curr.remove(num);
            }
        }
    }
}
