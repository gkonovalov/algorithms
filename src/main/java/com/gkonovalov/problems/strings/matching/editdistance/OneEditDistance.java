package com.gkonovalov.problems.strings.matching.editdistance;


/**
 * Created by Georgiy Konovalov on 12/15/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/one-edit-distance/">
 *          [Medium][161] - One Edit Distance
 *      </a>
 * </p>
 * Runtime Complexity: O(n*m).
 * Space Complexity:   O(n*m).
 */
public class OneEditDistance {

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "a"));
    }

    public static boolean isOneEditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][m] == 1;
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
