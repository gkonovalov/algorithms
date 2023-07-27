package com.gkonovalov.algorithms.strings.matching.editdistance;

/**
 * Created by Georgiy Konovalov on 27/07/2023.
 * <p>
 * Levenshtein Distance implementation, also known as Edit Distance. Levenshtein Distance, is a
 * measure of similarity between two strings. A smaller Levenshtein Distance indicates that the
 * strings are more similar, while a larger Levenshtein Distance indicates greater dissimilarity.
 * It calculates the minimum number of single-character insertions, deletions, or substitutions
 * required to transform one string into another. The Levenshtein Distance algorithm can be
 * efficiently implemented using dynamic programming. By storing the distances of smaller substrings
 * in a matrix, we can avoid redundant calculations and find the Levenshtein Distance for the entire
 * strings efficiently.
 * The algorithm is valuable for various applications, such as autocorrection in text editors,
 * DNA sequence comparison, and similarity analysis in natural language processing tasks.
 * </p>
 * Runtime Complexity: O(m * n) for the {@code calculateDistance}.
 * Space Complexity:   O(m * n) for {@code calculateDistance}.
 */
public class LevenshteinDistance {

    public int calculateDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
