package com.gkonovalov.problems.stack;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">
 *          [Easy][20] - Valid Parentheses
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code isValid},
 * Space Complexity:   O(n) for {@code isValid}.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("Is valid:" + isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        Stack<Character> stack = new Stack<>();

        for (char letter : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == map.get(letter)) {
                stack.pop();
            } else {
                stack.add(letter);
            }
        }
        return stack.isEmpty();
    }

}
