package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/edit-distance/">
 *          [Medium][72] - Edit Distance
 *      </a>
 * </p>
 * Runtime Complexity: O(n*m).
 * Space Complexity:   O(n*m),
 * O(n) for {@code climbStairs2}.
 */
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n1][n2];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
