package com.gkonovalov.problems.recursion.dp;


import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 15/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">
 *          [Medium][300] - Longest Increasing Subsequence
 *      </a>
 * </p>
 * Runtime Complexity: O(n^2) for {@code lengthOfLIS}.
 * Space Complexity:   O(n) for {@code lengthOfLIS}.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        int max = 0;

        for (int num : dp) {
            max = Math.max(max, num);
        }

        return max;
    }
}
