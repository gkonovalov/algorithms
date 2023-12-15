package com.gkonovalov.problems.arrays.searching.binarysearch;


/**
 * Created by Georgiy Konovalov on 8/04/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/search-insert-position/">
 *         [Easy][35] - Search Insert Position
 *     </a>
 * </p>
 * Runtime Complexity: O(log n).
 * Space Complexity:   O(1).
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println("Position:" + searchInsert(arr, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (target < nums[center]) {
                end = center - 1;
            } else if (target > nums[center]) {
                start = center + 1;
            } else {
                return center;
            }
        }

        return start;
    }
}
