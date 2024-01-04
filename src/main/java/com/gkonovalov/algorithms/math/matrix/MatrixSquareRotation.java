package com.gkonovalov.algorithms.math.matrix;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * The Matrix Rotation (90 degree) algorithm implementation.
 * </p>
 * Runtime Complexity: O(n m).
 * Space Complexity:   O(1).
 */
public class MatrixSquareRotation {

    public void clockWiseRotate(int[][] matrix) {
        reflectHorizontally(matrix);
        transpose(matrix);
    }

    public void clockWiseRotate2(int[][] matrix) {
        transpose(matrix);
        reflectVertically(matrix);
    }

    public void antiClockWiseRotate(int[][] matrix) {
        transpose(matrix);
        reflectHorizontally(matrix);
    }

    private void reflectHorizontally(int[][] matrix){
        int topRow = 0;
        int bottomRow = matrix.length - 1;

        while (topRow < bottomRow) {
            int[] temp = matrix[topRow];
            matrix[topRow] = matrix[bottomRow];
            matrix[bottomRow] = temp;
            topRow++;
            bottomRow--;
        }
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reflectVertically(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
