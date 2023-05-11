package algorithms.arrays.sorting;

import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 11/05/2023.
 * <p>
 * Bubble Sort implementation.
 * </p>
 * Runtime Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};

        sort(arr);

        System.out.println("Sorted Array:" + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
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
