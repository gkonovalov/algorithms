package com.gkonovalov.problems.arrays.matrix;

import java.util.Arrays;

/**
 * Created by Georgiy Konovalov on 14/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">
 *              [Medium][74] - Search a 2D Matrix
 *      </a>
 * </p>
 * Runtime Complexity: O(m log n) for {@code searchMatrix}.
 * Space Complexity:   O(1) for {@code searchMatrix}.
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Found: " + searchMatrix(arr, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int center = (end - start) / 2 + start;

            int candidate = matrix[center / n][center % n];

            if (candidate == target) {
                return true;
            } else if (candidate < target) {
                start = center + 1;
            } else {
                end = center - 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (Arrays.binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
