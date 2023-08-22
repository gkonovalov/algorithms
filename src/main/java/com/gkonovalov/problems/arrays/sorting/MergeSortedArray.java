package com.gkonovalov.problems.arrays.sorting;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Georgiy Konovalov on 21/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">
 *              [Easy][88] - Merge Sorted Array
 *      </a>
 * </p>
 * Runtime Complexity: O(n + m) for {@code merge}.
 * Space Complexity:   O(1) for {@code merge}.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        merge(new int[]{1, 3, 0, 0}, 4, new int[]{2, 5}, 2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;

        while (i >= 0) {
            int num1 = p1 < 0 ? Integer.MIN_VALUE : nums1[p1];
            int num2 = p2 < 0 ? Integer.MIN_VALUE : nums2[p2];

            if (num1 < num2) {
                nums1[i--] = num2;
                p2--;
            } else {
                nums1[i--] = num1;
                p1--;
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
