package com.gkonovalov.algorithms.math.matrix;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * The Matrix Inversion algorithm implementation.
 * Matrix inversion is the process of finding the inverse of a square matrix, denoted as A^(-1),
 * such that A * A^(-1) equals the identity matrix.
 * The identity matrix is a special square matrix with ones on the main diagonal and zeros elsewhere.
 * It acts as the multiplicative identity for matrices, similar to how the number 1 acts for scalar
 * multiplication.
 * Algorithm uses the Gauss-Jordan elimination method for matrix inversion.
 * </p>
 * Runtime Complexity: O(n^3).
 * Space Complexity:   O(n^2).
 */
public class MatrixInversion {

    public double[][] invert(double[][] matrix) throws IllegalArgumentException {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Invalid matrix dimensions for inversion!");
        }

        int n = matrix.length;

        double[][] augmentedMatrix = addIdentityMatrix(matrix, n );

        applyGaussJordanElimination(augmentedMatrix, n);

        return extractResult(augmentedMatrix, n);
    }

    private void applyGaussJordanElimination(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            double pivot = matrix[i][i];

            for (int j = 0; j < 2 * n; j++) {
                matrix[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];

                    for (int j = 0; j < 2 * n; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }
    }

    private double[][] addIdentityMatrix(double[][] matrix, int n) {
        double[][] augmentedMatrix = new double[n][2 * n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n + i] = 1.0;
        }

        return augmentedMatrix;
    }

    private double[][] extractResult(double[][] augmentedMatrix, int n) {
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(augmentedMatrix[i], n, result[i], 0, n);
        }

        return result;
    }
}
