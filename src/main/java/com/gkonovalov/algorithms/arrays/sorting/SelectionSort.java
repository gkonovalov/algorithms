package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Selection Sort is a simple sorting algorithm that works by repeatedly
 * finding the minimum element from the unsorted part of the array and
 * swapping it with the element at the beginning of the unsorted part.
 * It's important to note that Selection Sort has a quadratic time complexity,
 * making it less efficient compared to other sorting algorithms like
 * Merge Sort or Quick Sort.
 * </p>
 * Runtime Complexity: O(n^2).
 * Space Complexity:   O(1).
 */
public class SelectionSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[minIndex]) {
                    minIndex = k;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
