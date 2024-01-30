package com.gkonovalov.algorithms.strings.matching.regularexpressions;

/**
 * Created by Georgiy Konovalov on 1/30/2024.
 * <p>
 * Regular Expression Matching algorithm implementation.
 * Regular Expression Matching is a problem in computer science and string processing that
 * involves determining whether a given string matches a specified pattern represented by a
 * regular expression. Regular expressions are powerful and flexible patterns that describe
 * sets of strings. They are commonly used for tasks such as text search, text validation,
 * and data extraction.
 *
 * In the context of Regular Expression Matching, a regular expression (regex) is a sequence
 * of characters that defines a search pattern. The pattern may include various components,
 * such as literal characters, metacharacters, and quantifiers. Some common metacharacters
 * include '*', '.', '+', '?', and others, each with its own meaning.
 * </p>
 * Runtime Complexity: O(m n) for the {@code isMatchDP} and {@code isMatchDP2},
 *                     O(2^m+n) for the {@code isMatch}.
 * Space Complexity:   O(m n) for {@code isMatchDP} and {@code isMatchDP2},
 *                     O(2^m+n) for the {@code isMatch}.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatchDP(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);

                if (charP == charS || charP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (charS == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[m][n];
    }

    public boolean isMatchDP2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean match = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || match && dp[i + 1][j];
                } else {
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}

