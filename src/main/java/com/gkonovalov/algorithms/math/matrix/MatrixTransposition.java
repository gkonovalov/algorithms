package com.gkonovalov.algorithms.math.matrix;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * The Matrix Transposition algorithm implementation.
 * </p>
 * Runtime Complexity: O(n m) for {@code transpose} and {@code transposeSquare}.
 * Space Complexity:   O(1) for {@code transposeSquare},
 *                     O(n m) for {@code transpose}.
 */
public class MatrixTransposition {

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public void transposeSquare(int[][] matrix) throws IllegalArgumentException {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) {
            throw new IllegalArgumentException("Invalid matrix dimensions for transposition!");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
