package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Subsets algorithm implementation. In mathematics and combinatorics, subsets refer to all possible
 * combinations of elements that can be taken from a given set. A subset is a collection of elements taken
 * from the original set without considering the order of the elements. In other words, a subset is a set
 * that contains some or all of the elements from the original set.
 * For example, if we have a set {1, 2, 3}, some possible subsets are:
 *      {}, an empty set (contains no elements).
 *      {1}, containing only the element 1.
 *      {2}, containing only the element 2.
 *      {3}, containing only the element 3.
 *      {1, 2}, containing elements 1 and 2.
 *      {1, 3}, containing elements 1 and 3.
 *      {2, 3}, containing elements 2 and 3.
 *      {1, 2, 3}, containing all elements from the original set.
 * </p>
 * Runtime Complexity: O(2^n).
 * Space Complexity:   O(n).
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(generateSubsets(new int[]{1, 2, 3}));
    }

    private static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> curr, int start) {
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            Integer num = nums[i];

            curr.add(num);
            backtracking(nums, result, curr, i + 1);
            curr.remove(num);
        }
    }
}
