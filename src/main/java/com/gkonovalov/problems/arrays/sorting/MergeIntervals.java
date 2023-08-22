package com.gkonovalov.problems.arrays.sorting;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Georgiy Konovalov on 21/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/merge-intervals/">
 *              [Medium][56] - Merge Intervals
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n) for {@code merge}.
 * Space Complexity:   O(n) for {@code merge}.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println("Merge intervals:" + merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : intervals) {
            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
