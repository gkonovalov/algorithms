package com.gkonovalov.problems.stack;

import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/basic-calculator-ii/">
 *            [Medium][227] - Basic Calculator II
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code calculate},
 * Space Complexity:   O(n) for {@code calculate}.
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println("Result:" + calculate("3+2*2"));
    }

    public static int calculate(String s) {
        int num = 0;
        char control = '+';
        s += "+";
        Stack<Integer> stack = new Stack<>();

        for (Character letter : s.toCharArray()) {
            if (letter == ' ') {
                continue;
            }

            if (Character.isDigit(letter)) {
                num = num * 10 + (letter - '0');
            } else {
                switch (control) {
                    case '+':
                        stack.add(num);
                        break;
                    case '-':
                        stack.add(-num);
                        break;
                    case '/':
                        stack.add(stack.pop() / num);
                        break;
                    case '*':
                        stack.add(stack.pop() * num);
                        break;
                }
                control = letter;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            num += stack.pop();
        }

        return num;
    }
}
