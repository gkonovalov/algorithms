package com.gkonovalov.algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 5/04/2023.
 * <p>
 * Linear Search implementation.
 * This algorithm can work with sorted and unsorted data.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1).
 */
public class LinearSearch {

    public int search(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
