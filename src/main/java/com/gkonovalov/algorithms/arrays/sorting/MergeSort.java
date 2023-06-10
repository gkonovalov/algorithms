package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 18/05/2023.
 * <p>
 * Merge Sort is a divide-and-conquer algorithm that guarantees a worst-case
 * time complexity of O(n log n) for all input arrays. It divides the input
 * array into two halves, sorts them recursively, and then merges the sorted halves.
 * Merge Sort is a stable sorting algorithm, ensuring that elements with equal values
 * maintain their relative order after sorting. However, it does require additional
 * memory for the temporary array used in the merging process.
 * </p>
 * Runtime Complexity: O(n log n).
 * Space Complexity:   O(n).
 */
public class MergeSort {

    public void sort(int[] arr) {
        mergeSortHelper(arr, new int[arr.length], 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int[] aux, int start, int end) {
        if (start < end) {
            int center = start + (end - start) / 2;

            mergeSortHelper(arr, aux, start, center);
            mergeSortHelper(arr, aux, center + 1, end);
            mergeHalves(arr, aux, start, center, end);
        }
    }

    private void mergeHalves(int[] arr, int[] aux, int start, int center, int end) {
        for (int i = start; i <= end; i++) {
            aux[i] = arr[i];
        }

        int l = start;
        int r = center + 1;
        int curr = start;

        while (l <= center && r <= end) {
            if (aux[l] <= aux[r]) {
                arr[curr++] = aux[l++];
            } else {
                arr[curr++] = aux[r++];
            }
        }

        // Copy the rest of the left side of the array into the target array
        while (l <= center) {
            arr[curr++] = aux[l++];
        }
    }
}
