package com.gkonovalov.algorithms.arrays.sorting.quicksort;

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
 * to poor performance when the input is already sorted or contains many equal elements.
 *
 * Hoare's scheme is more efficient than Lomuto's partition scheme because it does three times
 * fewer swaps on average. Also Lomuto preforms relatively poorly when there is a high percentage
 * of duplicate values, whereas Hoare performs just fine in that situation.
 * </p>
 * Runtime Complexity: O(n log n) average for {@code sort},
 *                     O(n^2) worst case for {@code sort} - very rare for randomized pivot.
 * Space Complexity:   O(log n) - used in recursion stack.
 */
public class QuickSortPartitionHoare {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = randomizedPartitionHoare(arr, start, end);

            sort(arr, start, pivotIndex - 1);
            sort(arr, pivotIndex, end);
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

            if (start >= end) {
                break;
            }

            swap(arr, start++, end--);
        }

        return start;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
