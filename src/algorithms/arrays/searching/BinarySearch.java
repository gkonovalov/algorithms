package algorithms.arrays.searching;

import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 5/05/2023.
 * <p>
 * Binary Search implementation. Recursive and iterative approach.
 * </p>
 * Runtime Complexity: Average O(log n) and Worst Case O(log n)
 * for the {@code searchRecursive} and {@code searchIterative}
 * Space Complexity: O(n)
 */
public class BinarySearch {

    public static void main(final String[] args) {
        final int[] arr = {40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};

        Arrays.sort(arr);

        System.out.println("Sorted Array:" + Arrays.toString(arr));
        System.out.println("Binary Search Java:" + Arrays.binarySearch(arr, 42));
        System.out.println("Binary Search Iterative:" + searchIteratively(arr, 42));
        System.out.println("Binary Search Recursive:" + searchRecursively(arr, 42));
    }

    public static int searchIteratively(final int[] arr, final int num) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            final int center = (end - start) / 2 + start;

            if (num < arr[center]) {
                end = center - 1;
            } else if (num > arr[center]) {
                start = center + 1;
            } else {
                return center;
            }
        }

        return -1;
    }

    public static int searchRecursively(final int[] arr, final int num) {
        return searchRecursivelyHelper(arr, 0, arr.length - 1, num);
    }

    private static int searchRecursivelyHelper(final int[] arr, final int start, final int end, final int num) {
        while (start <= end) {
            final int center = (end - start) / 2 + start;

            if (num < arr[center]) {
                return searchRecursivelyHelper(arr, start, center - 1, num);
            } else if (num > arr[center]) {
                return searchRecursivelyHelper(arr, center + 1, end, num);
            } else {
                return center;
            }
        }
        return -1;
    }

}
