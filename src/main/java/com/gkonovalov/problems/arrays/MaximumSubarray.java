package com.gkonovalov.problems.arrays;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Implementation of Kadane's Algorithm which is used to find the maximum sum of a contiguous subarray
 * within an array of numbers.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">
 *             [Medium][53] - Maximum Subarray
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code maxSubarraySum}.
 * Space Complexity:   O(1) for {@code maxSubarraySum}.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("Max Subarray Sum:" + maxSubarraySum(arr));
    }

    public static int maxSubarraySum(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentSubarray = Math.max(nums[i], currentSubarray+nums[i]);
            maxSubarray = Math.max(currentSubarray, maxSubarray);
        }

        return maxSubarray;
    }
}
