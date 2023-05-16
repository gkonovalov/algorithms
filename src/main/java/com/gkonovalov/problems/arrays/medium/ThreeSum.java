package com.gkonovalov.problems.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 15/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/3sum/">
 *          [Medium][15] - Three Sum
 *      </a>
 * </p>
 * Runtime Complexity: O(todo) for {@code threeSum}.
 * Space Complexity:  O(todo) for {@code threeSum}.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println("Find three sum:" + threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            helper(i, result, nums);
        }
        return new ArrayList<>(result);
    }

    private static void helper(int first, HashSet<List<Integer>> result, int[] nums) {
        int second = first + 1;
        int third = nums.length - 1;

        while (second < third) {
            int sum = nums[first] + nums[second] + nums[third];

            if (sum > 0) {
                third--;
            } else if (sum < 0) {
                second++;
            } else {
                result.add(Arrays.asList(nums[first], nums[second++], nums[third--]));
            }
        }
    }

}
