package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number/">
 *          [Easy][1137] - N-th Tribonacci Number
 *      </a>
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1) for {@code tribonnacci2},
 *                     O(n) for {@code tribonacci}.
 */
public class NTribonacciNumber {

    public static void main(String[] args) {
        System.out.println("Find tribonacci number:" + tribonacci(4));
    }

    public static int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static int tribonnacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = {0, 1, 1};

        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }

        return dp[n % 3];
    }
}
