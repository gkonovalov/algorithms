package com.gkonovalov.problems.recursion.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/subsets/">
 *          [Medium][78] - Subsets
 *      </a>
 * </p>
 * Runtime Complexity: O(2^n).
 * Space Complexity:   O(n).
 */
public class Subsets {

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
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
