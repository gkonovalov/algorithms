package com.gkonovalov.problems.math;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 12/16/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/palindrome-number/">
 *          [Easy][9] - Palindrome Number
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code isPalindrome}.
 * Space Complexity:   O(1) for {@code isPalindrome}.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("Is palindrome:" + isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x <= 9) {
            return true;
        }


        int original = x;
        int reversed = 0;

        while (x > 0) {
            reversed = reversed * 10 + (x % 10);
            x = x / 10;
        }

        return original == reversed;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        if (x <= 9) {
            return true;
        }

        List<Integer> num = new ArrayList<>();

        while (x != 0) {
            num.add(x % 10);
            x = x / 10;
        }

        int left = 0;
        int right = num.size() - 1;

        while (left <= right) {
            if (num.get(left++) != num.get(right--)) {
                return false;
            }
        }
        return true;
    }
}
