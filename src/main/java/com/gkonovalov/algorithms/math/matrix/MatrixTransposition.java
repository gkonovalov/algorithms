package com.gkonovalov.algorithms.math.matrix;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * The Matrix Transposition algorithm implementation.
 * </p>
 * Runtime Complexity: O(n m).
 * Space Complexity:   O(n m).
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
}
