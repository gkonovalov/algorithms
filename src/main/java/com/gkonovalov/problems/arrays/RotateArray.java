package com.gkonovalov.problems.arrays;

/**
 * Created by Georgiy Konovalov on 14/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/rotate-array/">
 *              [Medium][189] - Rotate Array
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code rotate}.
 * Space Complexity:   O(1) for {@code rotate}.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};

        rotate(arr, 2);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void rotate2(int[] nums, int k) { //slow
        for (int i = 0; i < k; i++) {
            moveLast(nums);
        }
    }

    private static void moveLast(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            swap(nums, i + 1, i);
        }
    }
}
