package com.gkonovalov.problems.strings;


/**
 * Created by Georgiy Konovalov on 22/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/string-compression/">
 *             [Medium][443] - String Compression
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code compress}.
 * Space Complexity:   O(n) for {@code compress}.
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aaabccc".toCharArray()));
    }

    public static int compress(char[] chars) {
        int posLetter = 0;
        int posCounter = 0;

        while (posCounter < chars.length) {
            char item = chars[posCounter];
            int count = 0;

            while (posCounter < chars.length && chars[posCounter] == item) {
                count++;
                posCounter++;
            }

            chars[posLetter++] = item;

            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[posLetter++] = digit;
                }
            }
        }
        return posLetter;
    }
}
