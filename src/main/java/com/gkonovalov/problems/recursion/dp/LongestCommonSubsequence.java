package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 15/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/longest-common-subsequence/">
 *          [Medium][1143] - Longest Common Subsequence
 *      </a>
 * </p>
 * Runtime Complexity: O(mn) for {@code longestCommonSubsequence}.
 * Space Complexity:   O(mn) for {@code longestCommonSubsequence}.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence2("abcde","ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                if (text1.charAt(i - 1) == text2.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static String longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                if (text1.charAt(i - 1) == text2.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        while (n > 0 && m > 0) {
            if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
                lcs.insert(0, text1.charAt(n - 1));
                n--;
                m--;
            } else if (dp[n - 1][m] > dp[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }

        return lcs.toString();
    }
}
