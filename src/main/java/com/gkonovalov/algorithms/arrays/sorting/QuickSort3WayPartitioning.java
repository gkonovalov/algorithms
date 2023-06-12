package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * QuickSort with 3-way partitioning (Dutch National Flag Algorithm) extends the original
 * QuickSort algorithm to handle arrays with many duplicate elements more efficiently.
 * It partitions the array into three regions: elements less than the pivot, elements equal
 * to the pivot, and elements greater than the pivot. This modification reduces the number
 * of recursive calls and swaps required for duplicate elements, leading to improved performance
 * in scenarios with many duplicates.
 * </p>
 * Runtime Complexity: O(n log n) average for {@code sort},
 *                     O(n^2) worst case for {@code sort}
 * Space Complexity:   O(log n) - used in recursion stack.
 */
public class QuickSort3WayPartitioning {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int[] partitionIndices = partition(arr, low, high);

            int lt = partitionIndices[0];
            int gt = partitionIndices[1];

            sort(arr, low, lt - 1);
            sort(arr, gt + 1, high);
        }
    }

    private int[] partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int lt = start;
        int gt = end;
        int i = start + 1;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, i++, lt++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        return new int[]{lt, gt};
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
