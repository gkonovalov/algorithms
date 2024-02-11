package com.gkonovalov.problems.graph.searching.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">
 *          [Medium][54] - Spiral Matrix
 *      </a>
 * </p>
 * Runtime Complexity: O(m*n) for {@code spiralOrder}, {@code spiralOrder2}.
 * Space Complexity:  O(1) for {@code spiralOrder2} and O(m*n) for {@code spiralOrder}.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 4, 2, 2},
                {1, 3, 4, 2, 2},
                {1, 3, 4, 2, 2}
        };

        System.out.println("Spiral Order:" + spiralOrder(arr));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        dfs(matrix, result, 0, 0, false);
        return result;
    }

    private static void dfs(int[][] matrix, List<Integer> result, int row, int col, boolean isUp) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length || matrix[row][col] == Integer.MAX_VALUE) {
            return;
        }

        result.add(matrix[row][col]);
        matrix[row][col] = Integer.MAX_VALUE;

        if (isUp) {
            dfs(matrix, result, row - 1, col, true);
        }

        dfs(matrix, result, row, col + 1, false);
        dfs(matrix, result, row + 1, col, false);
        dfs(matrix, result, row, col - 1, false);
        dfs(matrix, result, row - 1, col, true);
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int length = row * col;

        int rowBegin = 0;
        int rowEnd = row - 1;
        int colBegin = 0;
        int colEnd = col - 1;

        for (int i = 0; i < length; i++) {
            for (int p = colBegin; p <= colEnd && result.size() < length; p++) {
                result.add(matrix[rowBegin][p]);
            }
            rowBegin++;

            for (int p = rowBegin; p <= rowEnd && result.size() < length; p++) {
                result.add(matrix[p][colEnd]);
            }
            colEnd--;

            for (int p = colEnd; p >= colBegin && result.size() < length; p--) {
                result.add(matrix[rowEnd][p]);
            }
            rowEnd--;

            for (int p = rowEnd; p >= rowBegin && result.size() < length; p--) {
                result.add(matrix[p][colBegin]);
            }
            colBegin++;
        }
        return result;
    }
}
