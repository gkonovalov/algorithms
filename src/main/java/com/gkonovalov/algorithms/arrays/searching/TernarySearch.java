package com.gkonovalov.algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 5/04/2023.
 * <p>
 * Ternary Search implementation. Ternary Search is a searching algorithm used to find the position
 * of a target value in a sorted array. It is similar to Binary Search, but instead of dividing the
 * array into two parts, Ternary Search divides it into three parts.
 * The algorithm compares the target value with two pivot elements, which divide the array into
 * three parts. If the target value is equal to any of the pivot elements, the search is successful,
 * and the algorithm returns the index of the pivot element. Otherwise, it narrows down the search
 * space to the corresponding part of the array.
 * The Ternary Search algorithm divides the search space by three at each step, making it more efficient
 * than Linear Search but slower than Binary Search. Its time complexity is O(log3(n)), which is
 * approximately O(log2(n)) since log3(n) is roughly log2(n)/log2(3).
 * </p>
 * Runtime Complexity: O(log3(n)).
 * Space Complexity:   O(1).
 */
public class TernarySearch {

    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;

            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }

            if (target < arr[mid1]) {
                end = mid1 - 1;
            } else if (target > arr[mid2]) {
                start = mid2 + 1;
            } else {
                start = mid1 + 1;
                end = mid2 - 1;
            }
        }

        return -1;
    }
}
