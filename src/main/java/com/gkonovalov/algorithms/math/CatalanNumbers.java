package com.gkonovalov.algorithms.math;


/**
 * Created by Georgiy Konovalov on 5/01/2024.
 * <p>
 * Catalan Numbers algorithm implementation.
 * Catalan numbers is a number sequence, which is found useful in a number of combinatorial problems,
 * often involving recursively-defined objects.
 * Ex. 1, 1, 2, 5, 14, 42, 132, 429, 1430
 * </p>
 * Runtime Complexity: O(n^2) for {@code catalanNumberDp},
 *                     O(3^n) for {@code catalanNumberRecursive}.
 * Space Complexity:   O(n) for {@code catalanNumberDp} and {@code catalanNumberRecursive}.
 */
public class CatalanNumbers {

    public long catalanNumberRecursive(int n) {
        long result = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            result += catalanNumberRecursive(i) * catalanNumberRecursive(n - i - 1);
        }

        return result;
    }

    public long catalanNumberDp(int n) {
        if (n <= 1) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
