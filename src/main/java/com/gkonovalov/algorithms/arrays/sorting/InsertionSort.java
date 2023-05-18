package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Insertion Sort has a time complexity of O(n^2), but it performs fewer
 * comparisons and swaps than Selection Sort on average.
 * For partially sorted arrays, it can run with complexity O(n).
 * However, in general, Insertion Sort is less efficient compared to other
 * sorting algorithms like Merge Sort or Quick Sort.
 * </p>
 * Runtime Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k > 0; k--) {
                if (arr[k - 1] > arr[k]) {
                    int temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
