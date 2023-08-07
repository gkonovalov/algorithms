package com.gkonovalov.algorithms.arrays;

/**
 * Created by Georgiy Konovalov on 07/08/2023.
 * <p>
 * Kadane's algorithm implementation. Kadane's is an efficient algorithm used to find the maximum sum subarray
 * in an array of integers. Given an array of numbers, the algorithm calculates the maximum sum of a
 * contiguous subarray within the array.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1).
 */
public class Kadane {

    public int maxSum(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
