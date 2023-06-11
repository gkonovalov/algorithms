package com.gkonovalov.algorithms.arrays.sorting;

import com.gkonovalov.algorithms.randomized.FisherYatesShuffle;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Quick Sort is a divide-and-conquer algorithm with an average case time complexity of O(n log n),
 * making it generally faster than Merge Sort, it also does not require additional memory, which is more
 * memory-efficient compared to Merge Sort. Quick Sort selects a pivot element and partitions the array
 * into two subarrays, recursively sorting each subarray. It's important to note that Quick Sort
 * is not a stable sorting algorithm, meaning that the relative order of equal elements may change
 * during the sorting process.
 * </p>
 * Runtime Complexity: O(n log n) average with randomly shuffled array,
 *                     O(n^2) worst case, very unlikely if used randomly shuffled array.
 * Space Complexity:   O(1).
 */
public class QuickSort {

    public void sort(int[] arr) {
        FisherYatesShuffle shuffle = new FisherYatesShuffle();
        shuffle.shuffle(arr);

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);

            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start + (end - start) / 2];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(arr, start++, end--);
            }
        }

        return start;
    }

    public void sort2(int[] arr) {
        FisherYatesShuffle shuffle = new FisherYatesShuffle();
        shuffle.shuffle(arr);

        quickSort2(arr, 0, arr.length - 1);
    }

    private void quickSort2(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition2(arr, start, end);

            quickSort2(arr, start, pivotIndex - 1);
            quickSort2(arr, pivotIndex + 1, end);
        }
    }

    private int partition2(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, ++i, end);

        return i;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
