package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/palindromic-substrings/">
 *          [Medium][647] - Palindromic Substrings
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code countSubstrings}.
 * Space Complexity:  O(n^2) for {@code countSubstrings}.
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println("Count Substrings:" + countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;

        for (int length = 0; length < s.length(); length++) {
            for (int pos = 0; pos + length < s.length(); pos++) {
                boolean isSame = s.charAt(pos) == s.charAt(pos + length);

                dp[pos][length] = length <= 1 ? isSame : isSame && dp[pos + 1][length - 2];

                if (dp[pos][length]) {
                    count++;
                }
            }
        }
        return count;
    }
}
