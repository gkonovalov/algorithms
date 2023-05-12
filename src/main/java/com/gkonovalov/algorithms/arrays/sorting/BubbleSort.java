package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 11/05/2023.
 * <p>
 * Bubble Sort implementation.
 * </p>
 * Runtime Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class BubbleSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] > arr[k]) {
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }
    }
}
