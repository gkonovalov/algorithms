package com.gkonovalov.problems.hastable;


import java.util.*;

/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/roman-to-integer/">
 *          [Easy][13] - Roman to Integer
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code romanToInt}.
 * Space Complexity:   O(1) for {@code romanToInt}.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("key"));
    }

    private static HashMap<Character, Integer> map = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s) {
        int prev = 0;
        int number = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = map.get(s.charAt(i));

            if (current < prev) {
                number -= current;
            } else {
                number += current;
            }

            prev = current;
        }

        return number;
    }
}
