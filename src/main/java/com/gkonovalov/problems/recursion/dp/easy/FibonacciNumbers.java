package com.gkonovalov.problems.recursion.dp.easy;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/fibonacci-number/">
 *          [Easy][509] - Fibonacci Number
 *      </a>
 * </p>
 * Runtime Complexity: O(2^n) for {@code fibRecursiveTopDown},
 *                     O(n) for {@code fibMemoizationTopDown}, {@code fibDPBottomUp},
 *                              {@code fibDPBottomUp2}, {@code fibIterativeBottomUp}
 *
 * Space Complexity:  O(n) for {@code fibRecursiveTopDown}, {@code fibMemoizationTopDown},
 *                             {@code fibDPBottomUp}
 *                    O(1) for {@code fibDPBottomUp2},  {@code fibIterativeBottomUp}
 * O(n) for {@code findDuplicate4}
 */
public class FibonacciNumbers {

    public static void main(String[] args) {
        System.out.println("Fibonacci number:" + fibDPBottomUp(5));
    }

    public static int fibRecursiveTopDown(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRecursiveTopDown(n - 1) + fibRecursiveTopDown(n - 2);
    }

    public static int fibMemoizationTopDown(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        return fibMemoizationTopDown(n - 1, memo) + fibMemoizationTopDown(n - 2, memo);
    }

    public static int fibDPBottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fibDPBottomUp2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = {0, 1};

        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }

        return dp[n % 2];
    }

    public static int fibIterativeBottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
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
