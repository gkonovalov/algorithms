package com.gkonovalov.algorithms.math;


/**
 * Created by Georgiy Konovalov on 22/06/2023.
 * <p>
 * Fibonacci Numbers implementation.
 * The Fibonacci numbers are a sequence of numbers in which each number is the sum of the two
 * preceding ones. The sequence starts with 0 and 1, and the subsequent numbers are obtained
 * by adding the previous two numbers.
 * The Fibonacci sequence can be defined as follows:
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2), for n > 1
 * </p>
 * Runtime Complexity: O(2^n) for {@code fibRecursiveTopDown},
 *                     O(n) for {@code fibMemoizationTopDown}, {@code fibDPBottomUp},
 *                              {@code fibDPBottomUp2}, {@code fibIterativeBottomUp}.
 * Space Complexity:  O(n) for {@code fibRecursiveTopDown}, {@code fibMemoizationTopDown}, {@code fibDPBottomUp},
 *                    O(1) for {@code fibDPBottomUp2},  {@code fibIterativeBottomUp},
 *                    O(n) for {@code findDuplicate4}.
 */
public class FibonacciNumbers {
    
    public int fibRecursiveTopDown(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRecursiveTopDown(n - 1) + fibRecursiveTopDown(n - 2);
    }

    public int fibMemoizationTopDown(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        return fibMemoizationTopDown(n - 1, memo) + fibMemoizationTopDown(n - 2, memo);
    }

    public int fibDPBottomUp(int n) {
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

    public int fibDPBottomUp2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = {0, 1};

        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }

        return dp[n % 2];
    }

    public int fibIterativeBottomUp(int n) {
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
