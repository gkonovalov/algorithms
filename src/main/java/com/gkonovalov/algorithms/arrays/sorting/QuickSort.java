package com.gkonovalov.algorithms.arrays.sorting;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Quick Sort is a divide-and-conquer algorithm with an average case time complexity of O(n log n),
 * making it generally faster than Merge Sort, it also does not require additional memory, which is
 * more memory-efficient compared to Merge Sort.
 *
 * In Quick Sort, we select a pivot element and partition the array into two subarrays. We recursively
 * sort each subarray using the same Quick Sort algorithm. It's important to note that Quick Sort is
 * not a stable sorting algorithm. This means that the relative order of equal elements may change
 * during the sorting process.
 *
 * Randomized Quick Sort differs from Quick Sort in the selection of the pivot element. Instead of
 * choosing a fixed pivot, Randomized Quick Sort selects a random pivot element during each
 * partitioning step. This randomness helps to avoid worst-case scenarios and achieve an average-case
 * time complexity of O(n log n). In contrast, Quick Sort uses a fixed pivot selection, which can lead
 * to poor performance in certain cases with a time complexity of O(n^2).
 *
 * The main difference between Lomuto Partition and Hoare Partition lies in the number of swaps
 * performed. Lomuto Partition tends to perform more swaps compared to Hoare Partition, which can make
 * it less efficient in terms of runtime.
 * </p>
 * Runtime Complexity: O(n log n) average for {@code randomizedSortHoare},
 *                     O(n^2) worst case for {@code randomizedSortHoare} - happens really rare,
 *                     O(n log n) average for {@code fixedSortLomuto},
 *                     O(n^2) worst case for {@code fixedSortLomuto} - happens in certain cases.
 * Space Complexity:   O(log n) - used in recursion stack.
 */
public class QuickSort {

    public void randomizedSortHoare(int[] arr) {
        randomizedSortHoare(arr, 0, arr.length - 1);
    }

    private void randomizedSortHoare(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = randomizedPartitionHoare(arr, start, end);

            randomizedSortHoare(arr, start, pivotIndex - 1);
            randomizedSortHoare(arr, pivotIndex, end);
        }
    }

    private int randomizedPartitionHoare(int[] arr, int start, int end) {
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

    public void fixedSortLomuto(int[] arr) {
        fixedSortLomuto(arr, 0, arr.length - 1);
    }

    private void fixedSortLomuto(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = fixedPartitionLomuto(arr, start, end);

            fixedSortLomuto(arr, start, pivotIndex - 1);
            fixedSortLomuto(arr, pivotIndex + 1, end);
        }
    }

    private int fixedPartitionLomuto(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pivotIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, pivotIndex++, i);
            }
        }

        swap(arr, pivotIndex, end);

        return pivotIndex;
    }

    public void randomizedSortLomuto(int[] arr) {
        randomizedSortLomuto(arr, 0, arr.length - 1);
    }

    private void randomizedSortLomuto(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = randomizedPartitionLomuto(arr, start, end);

            randomizedSortLomuto(arr, start, pivotIndex - 1);
            randomizedSortLomuto(arr, pivotIndex + 1, end);
        }
    }

    private int randomizedPartitionLomuto(int[] arr, int start, int end) {
        int randomPivot = ThreadLocalRandom.current().nextInt(start, end + 1);

        swap(arr, randomPivot, end);

        int pivot = arr[end];
        int pivotIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, pivotIndex++, i);
            }
        }

        swap(arr, pivotIndex, end);

        return pivotIndex;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
