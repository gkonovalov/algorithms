package com.gkonovalov.problems.arrays.binarysearch;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">
 *          [Medium][33] - Search in Rotated Sorted Array
 *      </a>
 * </p>
 * Runtime Complexity: O(log n).
 * Space Complexity: O(1).
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Search in rotated arr:" + search(arr, 0));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (nums[center] == target) {
                return center;
            }

            if (nums[start] <= nums[center]) {
                if (target < nums[center] && target >= nums[start]) {
                    end = center - 1;
                } else {
                    start = center + 1;
                }
            } else {
                if (target > nums[center] && target <= nums[end]) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }

        return -1;
    }

    public static int search2(int[] nums, int target) {
        int n = nums.length - 1;
        int start = 0;
        int end = n;


        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (nums[n] < nums[center]) {
                start = center + 1;
            } else {
                end = center - 1;
            }
        }

        int answer = binarySearch(nums, target, 0, start - 1);

        if (answer != -1) {
            return answer;
        }

        return binarySearch(nums, target, start, n);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (nums[center] == target) {
                return center;
            }

            if (target < nums[center]) {
                end = center - 1;
            } else {
                start = center + 1;
            }
        }
        return -1;
    }
}