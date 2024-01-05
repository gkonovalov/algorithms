package com.gkonovalov.algorithms.math.matrix.multiplication;

/**
 * Created by Georgiy Konovalov on 1/4/2024.
 * <p>
 * The Matrix Exponentiation algorithm implementation.
 * Matrix exponentiation is a technique used to efficiently calculate the power of a square matrix.
 * Given a square matrix A and a positive integer k, the goal is to compute the matrix A^k.
 * The most straightforward way to compute A^k is by performing matrix multiplication k−1 times.
 * However, this approach is computationally expensive, especially for large values of k. To optimize
 * this process, algorithms such as exponentiation by squaring are often used.
 * </p>
 * Runtime Complexity: O(n^3 log k).
 * Space Complexity:   O(n^2).
 */
public class MatrixExponentiation {

    public int[][] power(int[][] matrix, int p) throws IllegalArgumentException {
        int rowsA = matrix.length;
        int colsA = matrix[0].length;

        if (colsA != rowsA) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication!");
        }

        int[][] result = matrix;

        for (int n = 1; n < p; n++) {
            result = multiply(result, matrix);
        }

        return result;
    }

    public int[][] powerBySquaring(int[][] matrix, int p) {
        int rowsA = matrix.length;
        int colsA = matrix[0].length;

        if (colsA != rowsA) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication!");
        }

        int[][] result = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            result[i][i] = 1;
        }

        while (p > 0) {
            if (p % 2 == 1) {
                result = multiply(result, matrix);
            }

            matrix = multiply(matrix, matrix);
            p /= 2;
        }

        return result;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }
}
