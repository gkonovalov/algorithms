package com.gkonovalov.problems.graph.searching.bfs;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 12/15/2023.
 * <p>
 *@see <a href="https://leetcode.com/problems/word-break/">
 *          [Medium][139] - Word Break
 *      </a>
 * </p>
 * Runtime Complexity: O(n^3+m*k) for {@code wordBreak}, {@code wordBreakDP} where n length of s, m length of wordDict,
 *                                                       and k average length of the words in wordDict.
 * Space Complexity:  O(n+m*k) for {@code wordBreak}, {@code wordBreakDP} where n length of s, m length of wordDict,
 *                                                    and k average length of the words in wordDict.
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println("Can break:" + wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();

            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                String subStr = s.substring(start, end);

                if (visited.contains(end)) {
                    continue;
                }

                if (wordDict.contains(subStr)) {
                    visited.add(end);
                    queue.add(end);
                }
            }
        }
        return false;
    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int n = 1; n <= s.length(); n++) {
            for (int k = 0; k < n; k++) {
                if (dp[k] && words.contains(s.substring(k, n))) {
                    dp[n] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
