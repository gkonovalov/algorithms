package com.gkonovalov.algorithms.math;


/**
 * Created by Georgiy Konovalov on 5/01/2024.
 * <p>
 * The Binomial Coefficient algorithm implementation. The Binomial Coefficient represents the number
 * of ways to choose k elements from set of n different elements without taking into account the order
 * of arrangement of these elements (i.e., the number of unordered sets).
 * It is also known as "n choose k" or "combinations."
 *
 * The binomial coefficient is calculated using the formula:
 * C(n, k) = n! / (k! * (n - k)!)
 * </p>
 * Runtime Complexity: O(n*k) for {@code bcDP},
 *                     O(n+k) for {@code bcIterative},
 *                     O(n*max(k,n-k)) for {@code bcRecursive}.
 * Space Complexity:   O(n*k) for {@code bcDP},
 *                     O(1) for {@code bcIterative},
 *                     O(n*max(k,n-k)) for {@code bcRecursive}.
 */
public class BinomialCoefficient {

    public long bcRecursive(int n, int k) {
        if (k > n) {
            return 0;
        }

        if (k == 0 || k == n) {
            return 1;
        }

        return bcRecursive(n - 1, k - 1) + bcRecursive(n - 1, k);
    }

    public long bcDP(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }

    public int bcIterative(int n, int k) {
        int res = 1;

        for (int i = n - k + 1; i <= n; ++i) {
            res *= i;
        }

        for (int i = 2; i <= k; ++i) {
            res /= i;
        }

        return res;
    }
}
