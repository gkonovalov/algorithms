package com.gkonovalov.algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 27/07/2023.
 * <p>
 * Jump search implementation. Jump search is a searching algorithm used on sorted arrays or lists.
 * It is a relatively simple and efficient searching technique, especially when dealing with
 * large datasets. The algorithm makes use of the idea that the data is sorted, and it performs a
 * series of jumps to quickly narrow down the search range where the target element might be present.
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
