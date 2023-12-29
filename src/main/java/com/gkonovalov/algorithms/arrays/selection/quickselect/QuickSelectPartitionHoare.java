package com.gkonovalov.algorithms.arrays.selection.quickselect;

/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Quick Select is a selection algorithm that efficiently finds the kth smallest (or largest) element
 * in an unsorted list or array. It's a variation of the Quick Sort algorithm that focuses on partitioning
 * the elements to quickly narrow down the search space for the desired element. The key idea behind
 * QuickSelect is to choose a pivot element, partition the array around it, and then determine in which
 * partition the desired element lies. This way, only one partition needs to be further processed, which
 * reduces the average time complexity.
 *
 * Like Lomuto's partition scheme, Hoare's partitioning also would cause Quicksort to degrade to O(n^2)
 * for already sorted input, if the pivot was chosen as the first or the last element. With the middle
 * element as the pivot, however, sorted data results with (almost) no swaps in equally sized partitions
 * leading to best case behavior of Quicksort, i.e. O(n log(n)).
 *
 * Hoare's scheme is more efficient than Lomuto's partition scheme because it does three times
 * fewer swaps on average. Also Lomuto preforms relatively poorly when there is a high percentage
 * of duplicate values, whereas Hoare performs just fine in that situation.
 * </p>
 * Runtime Complexity: O(n) average for {@code select},
 *                     O(n^2) worst case, if data sorted.
 * Space Complexity:   O(1).
 */
public class QuickSelectPartitionHoare {

    public int select(int[] nums, int k, boolean isLargest) {
        int start = 0;
        int end = nums.length - 1;
        int index = isLargest ? nums.length - k : k - 1;

        while (start < end) {
            int pivotIndex = partitionHoare(nums, start, end);

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

    private int partitionHoare(int[] arr, int start, int end) {
        int pivot = arr[start + (end - start) / 2];

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

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
