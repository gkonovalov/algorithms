package com.gkonovalov.problems.strings;


/**
 * Created by Georgiy Konovalov on 22/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">
 *              [Medium][151] - Reverse Words in a String
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code reverseWords}.
 * Space Complexity:   O(n) for {@code reverseWords}.
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWordsOfString2(" the  sky  is  blue "));
        System.out.println(reverseWordsOfString2("test"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            if (!strs[i].isEmpty()) {
                sb.append(strs[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static String reverseWordsOfString2(String text) {
        StringBuilder sb = new StringBuilder();

        int n = text.length();
        int end = n;

        for (int i = n - 1; i >= 0; i--) {
            if (text.charAt(i) == ' ') {
                String str = text.substring(i, end).trim();

                if (!str.isEmpty()) {
                    sb.append(text, i, end);
                }

                end = i;
            }
        }

        sb.append(" ").append(text, 0, end < n ? end + 1 : end);

        return sb.toString().trim();
    }
}
