package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Partitions algorithm implementation. In mathematics, partitions refer to a way of breaking down a number
 * into a sum of smaller positive integers. A partition of a positive integer n is a way of expressing
 * n as a sum of positive integers, where the order of the summands does not matter. The individual summands
 * are called parts, and the number of partitions of n is denoted by p(n).
 * For example, the partitions of the number 4 are:
 * 4
 * 3 + 1
 * 2 + 2
 * 2 + 1 + 1
 * 1 + 1 + 1 + 1
 * </p>
 * Runtime Complexity: O(p(n) * m), where p(n) is the partition function representing the number of
 *                                  partitions of n, and m is the average size of the partitions.
 * Space Complexity:   O(m), where m is the average size of the partitions.
 */
public class Partitions {

    public List<List<Integer>> generatePartitions(int n, int maxNum) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, maxNum, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int n, int maxNum, List<List<Integer>> result, List<Integer> curr) {
        if (n == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (Integer num = 1; num <= Math.min(maxNum, n); num++) {
            curr.add(num);
            backtracking(n - num, num, result, curr);
            curr.remove(num);
        }
    }
}
