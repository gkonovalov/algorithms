package com.gkonovalov.algorithms.arrays.sorting;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Quick Sort is a divide-and-conquer algorithm with an average case time complexity of O(n log n),
 * making it generally faster than Merge Sort, it also does not require additional memory, which is more
 * memory-efficient compared to Merge Sort.
 * Quick Sort selects a pivot element and partitions the array into two subarrays, recursively sorting each subarray.
 * It's important to note that Quick Sort is not a stable sorting algorithm, meaning that the relative order of equal
 * elements may change during the sorting process.
 * Randomized Quick Sort differs from Quick Sort in the selection of the pivot element.
 * Instead of choosing a fixed pivot, Randomized Quick Sort selects a random pivot element during each
 * partitioning step. This randomness helps to avoid worst-case scenarios and achieve an average-case time
 * complexity of O(n log n). In contrast, Quick Sort uses a fixed pivot selection, which can lead to poor performance
 * in certain cases with a time complexity of O(n^2).
 * </p>
 * Runtime Complexity: O(n log n) average for {@code randomizedSort},
 *                     O(n^2) worst case for {@code fixedSort}.
 * Space Complexity:   O(1).
 */
public class QuickSort {

    public void randomizedSort(int[] arr) {
        randomizedQuickSort(arr, 0, arr.length - 1);
    }

    private void randomizedQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = randomizedPartition(arr, start, end);

            randomizedQuickSort(arr, start, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex, end);
        }
    }

    private int randomizedPartition(int[] arr, int start, int end) {
        int pivot = arr[ThreadLocalRandom.current().nextInt(start, end + 1)];

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

    public void fixedSort(int[] arr) {
        fixedQuickSort(arr, 0, arr.length - 1);
    }

    private void fixedQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = fixedPartition(arr, start, end);

            fixedQuickSort(arr, start, pivotIndex - 1);
            fixedQuickSort(arr, pivotIndex + 1, end);
        }
    }

    private int fixedPartition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pivotPointer = start;

        for (int j = start; j <= end; j++) {
            if (arr[j] < pivot) {
                swap(arr, pivotPointer++, j);
            }
        }

        swap(arr, pivotPointer, end);

        return pivotPointer;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
