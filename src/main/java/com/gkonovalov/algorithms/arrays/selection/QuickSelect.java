package com.gkonovalov.algorithms.arrays.selection;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Quick Select is a selection algorithm that is derived from the Quick Sort algorithm.
 * It is used to find the k-th smallest element in an unsorted array. The main idea behind
 * Quick Select is to partition the array similar to Quick Sort, but instead of recursively
 * sorting both halves, it selectively chooses to recurse on one side based on the position
 * of the pivot element.
 *
 * The main difference between Lomuto Partition and Hoare Partition lies in the number of swaps
 * performed. Lomuto Partition tends to perform more swaps compared to Hoare Partition, which can make
 * it less efficient in terms of runtime.
 * </p>
 * Runtime Complexity: O(n) average for {@code randomizedSelectionHoare},
 *                     O(n^2) worst case for {@code randomizedSelectionHoare} - happens really rare,
 *                     O(n) average for {@code fixedSelectionLomuto},
 *                     O(n^2) worst case for {@code fixedSelectionLomuto} - happens in certain cases.
 * Space Complexity:   O(1).
 */
public class QuickSelect {

    public int randomizedSelectionHoare(int[] nums, int k, boolean isLargest) {
        int start = 0;
        int end = nums.length - 1;
        int index = isLargest ? nums.length - k : k - 1;

        while (start < end) {
            int pivotIndex = randomizedPartitionHoare(nums, start, end);

            if (pivotIndex > index) {
                end = pivotIndex - 1;
            } else {
                start = pivotIndex;
            }
        }

        return nums[start];
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

    public int fixedSelectionLomuto(int[] nums, int k, boolean isLargest) {
        int start = 0;
        int end = nums.length - 1;
        int index = isLargest ? nums.length - k : k - 1;

        while (start < end) {
            int pivotIndex = fixedPartitionLomuto(nums, start, end);

            if (pivotIndex < index) {
                start = pivotIndex + 1;
            } else if (pivotIndex > index) {
                end = pivotIndex - 1;
            } else {
                return nums[pivotIndex];
            }
        }

        return nums[start];
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

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
