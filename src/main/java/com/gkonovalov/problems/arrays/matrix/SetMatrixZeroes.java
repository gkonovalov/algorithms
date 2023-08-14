package com.gkonovalov.problems.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 14/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/set-matrix-zeroes/">
 *          [Medium][73] - Set Matrix Zeroes
 *      </a>
 * </p>
 * Runtime Complexity: O(mn) for {@code setZeroes} and {@code setZeroes2}.
 * Space Complexity:   O(m+n) for {@code setZeroes},
 *                     O(1) for {@code setZeroes2}.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0},
                {0, 1}
        };

        setZeroes(arr);
    }

    public static void setZeroes(int[][] matrix) {
        List<int[]> pos = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    pos.add(new int[]{row, col});
                }
            }
        }

        for (int[] p : pos) {
            updateRowAndCol(matrix, p[0], p[1]);
        }
    }

    private static void updateRowAndCol(int[][] matrix, int r, int c) {
        for (int row = 0; row < matrix.length; row++) {
            if (isValid(matrix, row, c)) {
                matrix[row][c] = 0;
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            if (isValid(matrix, r, col)) {
                matrix[r][col] = 0;
            }
        }
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
            return false;
        }
        return true;
    }

    public static void setZeroes2(int[][] matrix) {
        boolean firstCol = false;
        boolean firstRow = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

    }
}
