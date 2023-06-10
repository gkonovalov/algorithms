package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 11/05/2023.
 * <p>
 * Bubble Sort is a sorting algorithm with a time complexity of O(n^2),
 * making it inefficient for large datasets. It is not recommended for
 * practical use due to its exponential increase in operations with input
 * size and significant memory swaps. Quicksort, mergesort, or heapsort are
 * more efficient and recommended for sorting large amounts of data.
 * </p>
 * Runtime Complexity: O(n^2).
 * Space Complexity:   O(1).
 */
public class BubbleSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] > arr[k]) {
                    swap(arr, i, k);
                }
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
