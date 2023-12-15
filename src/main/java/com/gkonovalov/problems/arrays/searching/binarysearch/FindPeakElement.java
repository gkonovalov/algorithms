package com.gkonovalov.problems.arrays.searching.binarysearch;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/find-peak-element/">
 *          [Medium][162] - Find Peak Element
 *      </a>
 * </p>
 * Runtime Complexity: O(log n) for {@code findPeakElement},
 *                     O(n) for {@code findPeakElement2}.
 * Space Complexity:   O(1).
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};

        System.out.println("Peak element:" + findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int center = (end - start) / 2 + start;

            if (nums[center] > nums[center + 1]) {
                end = center;
            } else {
                start = center + 1;
            }
        }
        return start;
    }


    public static int findPeakElement2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }

}
