package com.gkonovalov.problems.arrays.binarysearch;


/**
 * Created by Georgiy Konovalov on 8/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">
 *          [Medium][1011] - Capacity To Ship Packages Within D Days
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n).
 * Space Complexity:   O(1).
 */
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Ship within days:" + shipWithinDays(arr, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        while (start < end) {
            int capacity = (end - start) / 2 + start;

            if (countDays(weights, capacity) <= days) {
                end = capacity;
            } else {
                start = capacity + 1;
            }
        }
        return end;
    }

    private static int countDays(int[] weights, int capacity) {
        int days = 1;
        int total = 0;

        for (int weight : weights) {
            total += weight;

            if (total > capacity) {
                days++;
                total = weight;
            }
        }

        return days;
    }


}
