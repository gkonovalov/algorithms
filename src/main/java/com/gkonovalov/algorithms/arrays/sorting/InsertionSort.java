package com.gkonovalov.algorithms.arrays.sorting;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Insertion Sort is a simple sorting algorithm that works by dividing the input array
 * into a sorted and an unsorted portion. It iterates over the unsorted portion,
 * comparing each element with the elements in the sorted portion and inserting it
 * at the correct position. This process is repeated until the entire array
 * is sorted. It's important to note that Insertion Sort has a quadratic
 * time complexity, making it less efficient compared to other
 * sorting algorithms like Merge Sort or Quick Sort.
 * </p>
 * Runtime Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k > 0; k--) {
                if (arr[k] < arr[k - 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
