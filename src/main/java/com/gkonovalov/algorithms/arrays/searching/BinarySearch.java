package com.gkonovalov.algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 5/05/2023.
 * <p>
 * Binary Search implementation. Recursive and iterative approach.
 * Binary search is an efficient search algorithm used to find the position of a target
 * value within a sorted array or list. It follows a divide-and-conquer approach by repeatedly
 * dividing the search space in half, narrowing down the search range until the target value is
 * found or determined to be absent.
 * </p>
 * Runtime Complexity: O(log n) for the {@code searchIterative} and {@code searchIterative2},
 *                                      {@code searchRecursive}.
 * Space Complexity:   O(1) for {@code searchIterative} and {@code searchIterative2},
 *                     O(log n) for {@code searchRecursive}.
 */
public class BinarySearch {

    public int searchIterative(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (num < arr[center]) {
                end = center - 1;
            } else if (num > arr[center]) {
                start = center + 1;
            } else {
                return center;
            }
        }

        return -1;
    }

    public int searchIterative2(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int center = (end - start) / 2 + start;

            if (num <= arr[center]) {
                end = center;
            } else {
                start = center + 1;
            }
        }

        if (arr[end] != num) {
            return -1;
        } else {
            return end;
        }
    }

    public int searchRecursive(int[] arr, int num) {
        return searchRecursive(arr, 0, arr.length - 1, num);
    }

    private int searchRecursive(int[] arr, int start, int end, int num) {
        if (start <= end) {
            int center = (end - start) / 2 + start;

            if (num < arr[center]) {
                return searchRecursive(arr, start, center - 1, num);
            } else if (num > arr[center]) {
                return searchRecursive(arr, center + 1, end, num);
            } else {
                return center;
            }
        }

        return -1;
    }
}
