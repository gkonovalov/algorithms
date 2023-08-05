package com.gkonovalov.problems.arrays.selection;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/k-closest-points-to-origin/">
 *          [Medium][973] - K Closest Points to Origin
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n) for {@code kClosest}, O(n) for {@code kClosestQuickSelect}.
 * Space Complexity:   O(n) for {@code kClosest}, O(1) for {@code kClosestQuickSelect}.
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 2}, {-2, 2}}, 1)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]));

        for (int[] point : points) {
            minHeap.add(point);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] result = new int[minHeap.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static int[][] kClosestQuickSelect(int[][] points, int k) {
        int start = 0;
        int end = points.length - 1;
        int index = k - 1;

        while (start < end) {
            int pivotIndex = randomizedPartitionHoare(points, start, end);

            if (pivotIndex > index) {
                end = pivotIndex - 1;
            } else {
                start = pivotIndex;
            }
        }

        return Arrays.copyOfRange(points, 0, k);
    }

    private static int randomizedPartitionHoare(int[][] points, int start, int end) {
        int[] pivot = points[ThreadLocalRandom.current().nextInt(start, end + 1)];

        while (start <= end) {
            while (isLess(points[start], pivot)) {
                start++;
            }

            while (isLess(pivot, points[end])) {
                end--;
            }

            if (start >= end) {
                break;
            }

            swap(points, start++, end--);
        }

        return start;
    }

    private static void swap(int[][] points, int a, int b) {
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }

    private static boolean isLess(int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1]) < (p2[0] * p2[0] + p2[1] * p2[1]);
    }
}
