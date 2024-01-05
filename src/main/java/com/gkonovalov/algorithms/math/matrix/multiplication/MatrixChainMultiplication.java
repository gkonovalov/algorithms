package com.gkonovalov.algorithms.math.matrix.multiplication;


/**
 * Created by Georgiy Konovalov on 1/4/2024.
 * <p>
 * The Matrix Chain Multiplication algorithm implementation.
 * Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix
 * is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together
 * such that the total number of element multiplications is minimum.
 * </p>
 * Runtime Complexity: O(n^3) for {@code matrixChainOrderDP} and {@code matrixChainOrderMemoization},
 *                     O(2^n) for {@code matrixChainOrderRecursive}.
 * Space Complexity:   O(n^2) for {@code matrixChainOrderDP} and {@code matrixChainOrderMemoization},
 *                     O(n) for {@code matrixChainOrderRecursive}.
 */
public class MatrixChainMultiplication {

    public int matrixChainOrderDP(int[] dimensions) {
        int n = dimensions.length - 1;

        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;

                if (j == n) {
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public int matrixChainOrderRecursive(int[] dimensions) {
        return matrixChainOrderRecursive(dimensions, 1, dimensions.length - 1);
    }

    private int matrixChainOrderRecursive(int[] dimensions, int i, int j) {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = matrixChainOrderRecursive(dimensions, i, k) +
                        matrixChainOrderRecursive(dimensions, k + 1, j) +
                        dimensions[i - 1] * dimensions[k] * dimensions[j];

            if (count < min) {
                min = count;
            }
        }

        return min;
    }

    public int matrixChainOrderMemoization(int[] dimensions) {
        int n = dimensions.length;

        return matrixChainOrderMemoization(dimensions, new Integer[n][n] , 1, n - 1);
    }

    private int matrixChainOrderMemoization(int[] dimensions, Integer[][] memo, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        memo[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            memo[i][j] = Math.min(memo[i][j],
                            matrixChainOrderMemoization(dimensions, memo, i, k) +
                            matrixChainOrderMemoization(dimensions, memo, k + 1, j) +
                            dimensions[i - 1] * dimensions[k] * dimensions[j]);
        }

        return memo[i][j];
    }
}
