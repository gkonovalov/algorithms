package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/jump-game/">
 *          [Medium][55] - Jump Game
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code canJump}.
 * Space Complexity:   O(1) for {@code canJump}.
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println("Can jump to the end:" + canJumpDP(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Can jump to the end:" + canJumpDP(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(i + nums[i], reachable);
        }
        return true;
    }

    public static boolean canJumpDP(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int pos = nums.length - 2; pos >= 0; pos--) {
            int maxJump = Math.min(nums.length - 1, pos + nums[pos]);
            for (int i = pos + 1; i <= maxJump; i++) {
                if (dp[i]) {
                    dp[pos] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static boolean canJumpSlow(int[] nums) {
        return canJumpRecursive(nums, 0);
    }

    private static boolean canJumpRecursive(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            return true;
        }

        int maxJump = Math.min(nums.length - 1, pos + nums[pos]);
        for (int i = pos + 1; i <= maxJump; i++) {
            if (canJumpRecursive(nums, i)) {
                return true;
            }
        }
        return false;
    }
}
