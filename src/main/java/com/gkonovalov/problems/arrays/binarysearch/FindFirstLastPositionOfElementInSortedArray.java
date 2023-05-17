package com.gkonovalov.problems.arrays.binarysearch;


import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 8/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">
 *          [Medium][34] - Find First and Last Position of Element in Sorted Array
 *      </a>
 * </p>
 * Runtime Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindFirstLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6};

        System.out.println("Position:" + Arrays.toString(searchRange(arr, 4)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{
                binarySearch(nums, target, true),
                binarySearch(nums, target, false)
        };
    }

    private static int binarySearch(int[] nums, int target, boolean isLeft) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (target < nums[center]) {
                end = center - 1;
            } else if (target > nums[center]) {
                start = center + 1;
            } else {
                if (isLeft) {
                    end = center - 1;
                } else {
                    start = center + 1;
                }
                index = center;
            }

        }

        return index;
    }


}
