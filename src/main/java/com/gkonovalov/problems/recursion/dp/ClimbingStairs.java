package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">
 *          [Easy][70] - Climbing Stairs
 *      </a>
 * </p>
 * Runtime Complexity: O(n)
 * Space Complexity: O(1) for {@code climbStairs}, {@code climbStairs3}
 *                   O(n) for {@code climbStairs2}
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println("Distinct ways to climb stairs:" + climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = {1, 1};

        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }

        return dp[n % 2];
    }

    public static int climbStairs2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int climbStairs3(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 1;
        int second = 1;
        int third = 0;

        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }
}
