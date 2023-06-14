package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 13/06/2023.
 * <p>
 * Heap Sort is a comparison-based sorting algorithm that operates by using a binary heap data structure.
 * It has a worst-case time complexity of O(n log n) for both average and worst-case scenarios.
 * Heap Sort is an in-place sorting algorithm, which means it requires only a constant amount of additional space.
 * It is not a stable sorting algorithm, meaning that the relative order of elements with equal values may change.
 * </p>
 * Runtime Complexity: O(n log n).
 * Space Complexity:   O(1).
 */
public class HeapSort {

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            moveDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            moveDown(arr, i, 0);
        }
    }

    private void moveDown(int[] arr, int n, int parent) {
        int largest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != parent) {
            swap(arr, parent, largest);
            moveDown(arr, n, largest);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
