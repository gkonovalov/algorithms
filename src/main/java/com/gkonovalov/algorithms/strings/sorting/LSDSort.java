package com.gkonovalov.algorithms.strings.sorting;

/**
 * Created by Georgiy Konovalov on 1/24/2024.
 * <p>
 * LSD sorting algorithm implementation.
 * LSD (Least Significant Digit) Radix Sort is a non-comparative sorting algorithm designed
 * to handle integers or strings with fixed-width characters. Instead of relying on comparisons,
 * it organizes elements into buckets based on their radix. For elements with multiple significant
 * digits, this bucketing process is iteratively applied for each digit, maintaining the order
 * established in the previous step until all digits are considered.
 *
 * Notably, LSD Radix Sort is a stable algorithm, in contrast to its MSD (Most Significant Digit)
 * variant, as it preserves the relative order after each sorting iteration.
 *
 * This sorting technique is applicable to a variety of data that can be arranged lexicographically,
 * including integers, words, punch cards, playing cards, or mail. In certain benchmarks,
 * LSD Radix Sort has demonstrated superior speed compared to more general-purpose sorting algorithms,
 * sometimes exhibiting a speed advantage ranging from 50% to three times faster.
 * </p>
 * Runtime Complexity: O(w n) for the {@code sort}, where n - input size and w - word size.
 * Space Complexity:   O(n+r) for {@code sort}, where n - input size and r - radix.
 */
public class LSDSort {

    private final int R = 256;

    public void sort(String[] arr, int w) {
        for (int i = w - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    private void countingSort(String[] arr, int pos){
        int n = arr.length;
        int[] count = new int[R + 1];

        String[] aux = new String[n];

        for (int i = 0; i < n; i++) {
            count[arr[i].charAt(pos) + 1]++;
        }

        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        for (int i = 0; i < n; i++) {
            aux[count[arr[i].charAt(pos)]++] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = aux[i];
        }
    }
}

