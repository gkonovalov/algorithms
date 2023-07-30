package com.gkonovalov.algorithms.arrays.searching;

import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 30/07/2023.
 * <p>
 * Exponential search, also known as galloping search, is a search algorithm designed for finding a specific
 * target value in a sorted array. It is an improvement over the basic linear search by leveraging the
 * sorted nature of the array to perform fewer comparisons.
 * The algorithm starts with a small range around the beginning of the array and keeps doubling the size of
 * the range until it finds a range that contains the target value or exceeds the array boundaries. Once
 * the appropriate range is identified, a binary search is performed within that range to locate the
 * target value.
 * Exponential search has a time complexity of O(log n), but its performance can
 * vary depending on the distribution of the data and the location of the target value. In the worst-case
 * scenario, it can perform similar to a linear search if the target value is close to the beginning of
 * the array. However, for large arrays, it can be more efficient than binary search due to fewer
 * comparisons in each iteration.
 * </p>
 * Runtime Complexity: O(log n) - average, O(n) - worst case  for the {@code search}.
 * Space Complexity:   O(1) for {@code search}.
 */
public class ExponentialSearch {

    public int search(int[] arr, int target) {
        int n = arr.length;

        if (arr[0] == target) {
            return 0;
        }

        int i = 1;
        while (i < n && arr[i] <= target) {
            i = i * 2;
        }

        int result = Arrays.binarySearch(arr, i / 2, Math.min(i, n - 1), target);
        if (result >= 0) {
            return result;
        }

        return -1;
    }
}
