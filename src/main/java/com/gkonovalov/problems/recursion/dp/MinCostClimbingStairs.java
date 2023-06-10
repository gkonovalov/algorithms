package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 *          [Easy][746] - Min Cost Climbing Stairs
 *      </a>
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(n) for {@code minCostClimbingStairs},
 *                     O(1) for {@code minCostClimbingStairs2}, {@code minCostClimbingStairs3}.
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] arr = {10, 15, 20};

        System.out.println("Min cost to climb stairs:" + minCostClimbingStairs(arr));
    }


    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }

        return dp[n];
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[n - 1], cost[n - 2]);
    }

    public static int minCostClimbingStairs3(int[] cost) {
        int oneStepBehind = cost[0];
        int twoStepsBehind = cost[1];
        int cur = 0;

        for (int i = 2; i < cost.length; i++) {
            cur = Math.min(oneStepBehind, twoStepsBehind) + cost[i];
            oneStepBehind = twoStepsBehind;
            twoStepsBehind = cur;
        }

        return Math.min(oneStepBehind, twoStepsBehind);
    }
}
