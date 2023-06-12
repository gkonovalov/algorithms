package com.gkonovalov.problems.arrays;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Implementation of Kadane's Algorithm which is used to find the maximum sum of a contiguous subarray
 * within an array of numbers.
 *
 * @see <a href="https://leetcode.com/problems/3sum/">
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

    public static int maxSubarraySum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
