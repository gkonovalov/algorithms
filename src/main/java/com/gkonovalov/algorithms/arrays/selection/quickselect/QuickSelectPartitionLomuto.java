package com.gkonovalov.algorithms.arrays.selection.quickselect;

import java.util.concurrent.ThreadLocalRandom;

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
 * In the very early versions of QuickSort, the rightmost element of the partition would often be chosen as
 * the pivot element. Unfortunately, this causes worst-case behavior on already sorted arrays, which is a
 * rather common use-case. The problem was easily solved by choosing either a random index for the pivot,
 * choosing the middle index of the partition or (especially for longer partitions) choosing the median of
 * the first, middle and last element of the partition for the pivot.
 *
 * Hoare's scheme is more efficient than Lomuto's partition scheme because it does three times
 * fewer swaps on average. Also Lomuto preforms relatively poorly when there is a high percentage
 * of duplicate values, whereas Hoare performs just fine in that situation.
 * </p>
 * Runtime Complexity: O(n) average for {@code select} common if randomized pivot chosen,
 *                     O(n^2) worst case for {@code select} very rare for randomized pivot.
 * Space Complexity:   O(1).
 */
public class QuickSelectPartitionLomuto {

    public int select(int[] nums, int k, boolean isLargest) {
        int start = 0;
        int end = nums.length - 1;
        int index = isLargest ? nums.length - k : k - 1;

        while (start < end) {
            int pivotIndex = randomizedPartitionLomuto(nums, start, end);

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

    private int randomizedPartitionLomuto(int[] arr, int start, int end) {
        int randomPivot = ThreadLocalRandom.current().nextInt(start, end + 1);

        swap(arr, randomPivot, end);

        int pivot = arr[end];
        int storeIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, storeIndex++, i);
            }
        }

        swap(arr, storeIndex, end);

        return storeIndex;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
