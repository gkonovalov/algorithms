package com.gkonovalov.algorithms.math.matrix.multiplication;


/**
 * Created by Georgiy Konovalov on 1/4/2024.
 * <p>
 * The Sparse Matrix Multiplication algorithm implementation.
 * Let's consider two matrices A and B, where A is an (m x n) matrix and B is an (n x p) matrix.
 * The resulting matrix Result, obtained by multiplying A and B, will be of size (m x p).
 * Each element Result[i][j] is calculated by taking the dot product of the i-th row of matrix A and
 * the j-th column of matrix B.
 *
 * For matrix multiplication, the number of columns in the first matrix must be equal to the number
 * of rows in the second matrix. The resulting matrix, known as the matrix product, has the number of
 * rows of the first and the number of columns of the second matrix. The product of matrices A and B
 * is denoted as AB.
 * </p>
 * Runtime Complexity: O(m * n * p) - where A[m x n], B[n x p], Result[m x p].
 * Space Complexity:   O(m * p).
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] a, int[][] b) throws IllegalArgumentException {
        int rowsA = a.length;
        int rowsB = b.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication!");
        }

        int[][] result = new int[rowsA][colsB];

        for (int row = 0; row < rowsA; row++) {
            for (int element = 0; element < colsA; element++) {
                if (a[row][element] != 0) {
                    for (int col = 0; col < colsB; col++) {
                        if (b[element][col] != 0) {
                            result[row][col] += a[row][element] * b[element][col];
                        }
                    }
                }
            }
        }

        return result;
    }
}
