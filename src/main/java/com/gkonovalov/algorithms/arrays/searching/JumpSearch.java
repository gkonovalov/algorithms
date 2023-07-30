package com.gkonovalov.algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 27/07/2023.
 * <p>
 * Jump Search implementation. Jump search is a searching algorithm designed to find a specific target
 * value in a sorted array. It is an improvement over linear search, which checks each element in the
 * array one by one. Jump search performs fewer comparisons by "jumping" ahead in the array in
 * fixed-sized steps. The algorithm makes use of the idea that the data is sorted, and it
 * performs a series of jumps to quickly narrow down the search range where the target element might
 * be present.
 * Jump search is most effective for large, sorted arrays, especially when binary search is not applicable
 * due to the lack of random access (e.g., when searching in linked lists) or the high cost of accessing
 * elements (e.g., when searching in external storage). However, for small arrays, binary search or
 * interpolation search may perform better.
 * </p>
 * Runtime Complexity: O(sqrt(n)) for the {@code search}.
 * Space Complexity:   O(1) for {@code search}.
 */
public class JumpSearch {

    public int search(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += Math.floor(Math.sqrt(n));

            if (prev >= n) {
                return -1;
            }
        }

        while (arr[prev] < target) {
            prev++;

            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (arr[prev] == target) {
            return prev;
        }

        return -1;
    }
}
