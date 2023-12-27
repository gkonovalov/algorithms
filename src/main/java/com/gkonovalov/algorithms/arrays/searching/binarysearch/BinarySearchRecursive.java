package com.gkonovalov.algorithms.arrays.searching.binarysearch;

/**
 * Created by Georgiy Konovalov on 5/05/2023.
 * <p>
 * Binary Search recursive implementation.
 * Binary search is an efficient search algorithm used to find the position of a target
 * value within a sorted array or list. It follows a divide-and-conquer approach by repeatedly
 * dividing the search space in half, narrowing down the search range until the target value is
 * found or determined to be absent.
 * </p>
 * Runtime Complexity: O(log n) for the {@code searchRecursive}.
 * Space Complexity:   O(log n) for {@code searchRecursive}.
 */
public class BinarySearchRecursive {

    public int search(int[] arr, int num) {
        return searchRecursivelyHelper(arr, 0, arr.length - 1, num);
    }

    private int searchRecursivelyHelper(int[] arr, int start, int end, int num) {
        if (start <= end) {
            int center = (end - start) / 2 + start;

            if (num < arr[center]) {
                return searchRecursivelyHelper(arr, start, center - 1, num);
            } else if (num > arr[center]) {
                return searchRecursivelyHelper(arr, center + 1, end, num);
            } else {
                return center;
            }
        }

        return -1;
    }
}
