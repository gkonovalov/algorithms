package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 31/07/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">
 *          [Medium][5] - Longest Palindromic Substring
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code longestPalindromeDP},
 *                     O(n^3) for {@code longestPalindromeSlow}, {@code longestPalindromeSlow2}.
 * Space Complexity:   O(n^2) for {@code longestPalindromeDP},
 *                     O(1) for {@code longestPalindromeSlow}, {@code longestPalindromeSlow2}.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindromeDP("babad"));
        System.out.println(longestPalindromeDP("abbbbc"));
        System.out.println(longestPalindromeDP("ac"));
        System.out.println(longestPalindromeDP("a"));
    }

    public static String longestPalindromeDP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int maxLength = 0;
        int start = 0;

        for (int length = 0; length < s.length(); length++) {
            for (int pos = 0; pos + length < s.length(); pos++) {
                boolean isEqual = s.charAt(pos) == s.charAt(pos + length);

                dp[pos][length] = length <= 1 ? isEqual : isEqual && dp[pos + 1][length - 2];

                if (dp[pos][length] && length > maxLength) {
                    start = pos;
                    maxLength = length;
                }
            }
        }

        return s.substring(start, start + maxLength + 1);
    }

    public static String longestPalindromeSlow(String s) {
        int maxLength = 0;
        int start = 0;

        for (int offset = 0; offset < s.length(); offset++) {
            for (int length = 0; offset + length < s.length(); length++) {
                if (isPalindrome(s, offset, offset + length) && length > maxLength) {
                    maxLength = length;
                    start = offset;
                }
            }
        }
        return s.substring(start, start + maxLength + 1);
    }

    public static String longestPalindromeSlow2(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (isPalindrome(s, start, start + length - 1)) {
                    return s.substring(start, start + length);
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
