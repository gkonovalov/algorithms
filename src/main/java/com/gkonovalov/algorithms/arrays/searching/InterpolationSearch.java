package com.gkonovalov.algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 30/07/2023.
 * <p>
 * Interpolation Search implementation. Interpolation Search is a search algorithm designed to find a
 * specific target value in a sorted array. It is an improvement over binary search for uniformly
 * distributed data. While binary search always divides the search space in half, interpolation search
 * estimates the position of the target value based on the distribution of the data.
 * The algorithm calculates an approximate position for the target value by using linear interpolation
 * between the minimum and maximum values of the array. It then checks whether the estimated position
 * holds the target value. If the value at the estimated position is smaller than the target, the search
 * continues in the right subarray; if it is larger, the search continues in the left subarray.
 * This process repeats until the target value is found or the search space is exhausted.
 * The time complexity of interpolation search is typically better than binary search for uniformly
 * distributed data. In the best-case scenario, it can achieve O(log log n) time complexity, which is
 * faster than O(log n) of binary search. However, in the worst-case scenario, when the data is not
 * uniformly distributed, the time complexity can degrade to O(n).
 * </p>
 * Runtime Complexity: O(n) - worst key, O(log(log n)) - average case for the {@code search}.
 * Space Complexity:   O(1) for {@code search}.
 */
public class InterpolationSearch {

    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            int position = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[position] == target) {
                return position;
            } else if (arr[position] < target) {
                low = position + 1;
            } else {
                high = position - 1;
            }
        }

        return -1;
    }
}
