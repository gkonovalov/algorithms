package com.gkonovalov.problems.arrays;


import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">
 *          [Medium][6] - Zigzag Conversion
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code convert}.
 * Space Complexity:   O(n) for {@code convert}.
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        int i = 0;
        boolean isUp = false;

        for (char letter : s.toCharArray()) {
            arr[i] += letter;

            if (isUp) {
                i--;
            } else {
                i++;
            }

            if (i == numRows - 1) {
                isUp = true;
            }

            if (i == 0) {
                isUp = false;
            }
        }

        StringBuffer sb = new StringBuffer();

        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
