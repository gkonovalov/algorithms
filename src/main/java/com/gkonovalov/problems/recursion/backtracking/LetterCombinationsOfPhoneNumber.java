package com.gkonovalov.problems.recursion.backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">
 *          [Medium][17] - Letter Combinations of a Phone Number
 *      </a>
 * </p>
 * Runtime Complexity: O(n 4^n) for {@code isValid},
 * Space Complexity:   O(n) for {@code isValid}.
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println("Letter Combinations:" + letterCombinations("23"));
    }

    private static Map<Character, List<Character>> map = Map.of(
            '1', List.of(),
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtracking(digits, result, "", 0);

        return result;
    }

    private static void backtracking(String digits, List<String> result, String curr, int pos) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }

        for (Character letter : map.get(digits.charAt(pos))) {
            backtracking(digits, result, curr + letter, pos + 1);
        }
    }
}
