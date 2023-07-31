package com.gkonovalov.problems.strings.slidingwindow;


import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Georgiy Konovalov on 31/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">
 *          [Medium][3] - Longest Substring Without Repeating Characters
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code lengthOfLongestSubstring},
 * Space Complexity:   O(n) for {@code lengthOfLongestSubstring}.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcabc"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;

        HashSet<Character> window = new HashSet<>();

        while (end < s.length()) {
            if (window.isEmpty() || !window.contains(s.charAt(end))) {
                window.add(s.charAt(end++));
                max = Math.max(max, window.size());
            } else {
                window.remove(s.charAt(start++));
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char letter = s.charAt(end);

            if (map.containsKey(letter)) {
                start = Math.max(start, map.get(letter) + 1);
            }

            max = Math.max(max, end - start + 1);

            map.put(letter, end);
        }

        return max;
    }
}
