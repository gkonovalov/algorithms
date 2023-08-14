package com.gkonovalov.problems.stack;

import java.util.Stack;

/**
 * Created by Georgiy Konovalov on 14/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/simplify-path/">
 *          [Medium][71] - Simplify Path
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code simplifyPath},
 * Space Complexity:   O(n) for {@code simplifyPath}.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println("Result:" + simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String item : arr) {
            if (item.isEmpty() || item.equals(".")) {
                continue;
            }

            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(item);
            }
        }

        StringBuffer sb = new StringBuffer();

        for (String item : stack) {
            sb.append("/").append(item);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
