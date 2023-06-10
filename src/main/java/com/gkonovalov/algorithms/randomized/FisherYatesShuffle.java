package com.gkonovalov.algorithms.randomized;

import java.util.Random;

/**
 * Created by Georgiy Konovalov on 18/05/2023.
 * <p>
 * The Fisher-Yates Shuffle algorithm, also known as the Knuth Shuffle,
 * is a technique used to randomly shuffle the elements of an array.
 * It ensures that every possible permutation of the array is equally likely.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1).
 */
public class FisherYatesShuffle {

    public void shuffle(int[] arr) {
        Random rnd = new Random();

        for (int i = 0; i < arr.length; i++) {
            int rndIndex = rnd.nextInt(i + 1);

            swap(arr, i, rndIndex);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
