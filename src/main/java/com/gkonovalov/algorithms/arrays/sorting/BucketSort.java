package com.gkonovalov.algorithms.arrays.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Georgiy Konovalov on 27/07/2023.
 * <p>
 * Bucket Sort implementation. Bucket Sort is a sorting algorithm that works by distributing the
 * elements of an array into a fixed number of buckets and then sorting each bucket individually.
 * It is an example of a distribution sort, which means it operates by dividing the input into
 * several smaller buckets and then sorting each bucket using another sorting algorithm
 * (e.g., insertion sort or quicksort).
 * <p>
 * Bucket Sort is most effective when the input elements are uniformly distributed over a range and
 * when the number of elements in each bucket is not significantly large. In such cases, Bucket Sort
 * can achieve a linear time complexity. However, in the worst case, when all elements fall into
 * the same bucket and require sorting, the time complexity can become O(n^2), where n is the number
 * of elements in the input array.
 * <p>
 * One of the advantages of Bucket Sort is that it can be efficient for sorting elements with a
 * specific distribution, such as floating-point numbers in a certain range or non-negative integers.
 * It is commonly used when the range of the input elements is known or when the data is uniformly
 * distributed over a small range.
 * </p>
 * Runtime Complexity: O(n^2).
 * Space Complexity:   O(n).
 */
public class BucketSort {

    public void sort(double[] arr) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        int n = arr.length - 1;

        for (double num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        ArrayList<ArrayList<Double>> buckets = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            int bucketIndex = (int) ((arr[i] - min) * n  / (max - min));
            buckets.get(bucketIndex).add(arr[i]);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(buckets.get(i));
        }

        int index = 0;
        for (int i = 0; i <= n; i++) {
            for (double num : buckets.get(i)) {
                arr[index++] = num;
            }
        }
    }
}
