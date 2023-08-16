package com.gkonovalov.problems.randomization;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Georgiy Konovalov on 15/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/shuffle-an-array/">
 *          [Medium][384] - Shuffle an Array
 *      </a>
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(n).
 */
public class ShuffleAnArray {

    public static void main(String[] args) {
        Solution sol = new Solution(new int[]{1, 2, 3});

        System.out.println(Arrays.toString(sol.shuffle()));
    }

    static class Solution {
        private Random rnd;
        private int[] original;
        private int[] nums;

        public Solution(int[] nums) {
            this.rnd = new Random();
            this.nums = nums;
            this.original = nums.clone();
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                swap(nums, i, rnd.nextInt(i + 1));
            }
            return nums;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
