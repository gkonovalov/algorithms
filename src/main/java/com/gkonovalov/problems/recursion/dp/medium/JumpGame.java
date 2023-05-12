package com.gkonovalov.problems.recursion.dp.medium;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/jump-game/">
 *          [Medium][55] - Jump Game
 *      </a>
 * </p>
 * Runtime Complexity: O(n)
 * Space Complexity: O(1) for {@code climbStairs}, {@code climbStairs3}
 *                   O(n) for {@code climbStairs2}
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println("Can jump to the end:" + canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        return false; //todo
    }
}
