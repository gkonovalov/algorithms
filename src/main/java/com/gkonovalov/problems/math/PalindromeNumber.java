package com.gkonovalov.problems.math;


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

        int original = x;
        int reverted = 0;

        while (x > 0) {
            reverted = reverted * 10 + x % 10;
            x = x / 10;
        }

        return original == reverted;
    }
}
