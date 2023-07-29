package com.gkonovalov.algorithms.arrays.selection;

import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 28/07/2023.
 * <p>
 * The BFPRT (Blum-Floyd-Pratt-Rivest-Tarjan) algorithm implementation, also known as the "median of medians".
 * The "median of medians" is a selection algorithm used to find the k-th smallest/biggest element in an unsorted array.
 * It improves the worst-case performance of the QuickSelect algorithm by selecting good pivot elements to
 * partition the array. The main idea of the "median of medians" algorithm is to find an approximate median of the
 * array by dividing it into groups of five elements each and then finding the median of each group. The medians of
 * these groups are used to find the "median of medians", which becomes the pivot for partitioning the array.
 * By selecting a good pivot, the "median of medians" algorithm ensures that the partition step divides the array
 * into roughly equal-sized partitions, which helps in reducing the number of comparisons required to find the
 * k-th smallest element.
 * The "median of medians" algorithm has a time complexity of O(n), where n is the number of elements in the array,
 * making it a linear-time algorithm. This makes it more efficient than the simple QuickSelect algorithm, which can
 * have a worst-case time complexity of O(n^2) in some cases.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(log n).
 */
public class MedianOfMedians {

    public int findKElement(int[] arr, int k, boolean isLargest) {
        return selectBFPRT(arr, isLargest ? arr.length - k : k - 1);
    }

    private int selectBFPRT(int[] arr, int k) {
        int n = arr.length;

        if (n <= 10) {
            Arrays.sort(arr);
            return arr[k];
        }

        int pivot = getPivot(arr);

        int[] l1 = Arrays.stream(arr).filter(num -> num < pivot).toArray();
        int[] l2 = Arrays.stream(arr).filter(num -> num == pivot).toArray();
        int[] l3 = Arrays.stream(arr).filter(num -> num > pivot).toArray();

        if (k <= l1.length) {
            return selectBFPRT(l1, k);
        } else if (k > l1.length + l2.length) {
            return selectBFPRT(l3, k - l1.length - l2.length);
        } else {
            return pivot;
        }
    }

    private int getPivot(int[] arr) {
        int[] x = new int[arr.length / 5];

        for (int i = 0; i < x.length; i++) {
            x[i] = selectBFPRT(Arrays.copyOfRange(arr, i * 5, i * 5 + 5), 3);
        }

        return selectBFPRT(x, (arr.length / 10));
    }
}
