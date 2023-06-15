package com.gkonovalov.algorithms.arrays.sorting;


/**
 * Created by Georgiy Konovalov on 14/06/2023.
 * <p>
 * Counting Sort algorithm works by counting the occurrences of each distinct element
 * in the input array and then using those counts to determine the sorted order.
 * It is efficient when the range of input values is small compared to the number of
 * elements to be sorted. It is a stable sorting algorithm, meaning elements with equal
 * values maintain their relative order in the sorted output. Counting Sort has a time
 * complexity of O(n + k), where n is the number of elements to be sorted and k is the
 * range of input values.
 * </p>
 * Runtime Complexity: O(n+k).
 * Space Complexity:   O(k).
 */
public class CountingSort {

    public int[] sortPositive(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int[] count = new int[max + 1];

        for (int i : arr) {
            count[i]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return sorted;
    }

    public int[] sortNegative(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        int[] count = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        return sorted;
    }
}
