package com.gkonovalov.problems.arrays.matrix;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/rotate-image/">
 *          [Medium][48] - Rotate Image
 *      </a>
 * </p>
 * Runtime Complexity: O(m) for {@code rotate}.
 * Space Complexity:   O(1) for {@code rotate}.
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {2, 1}
        };

        rotate(arr);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix.length;

        int topRow = 0;
        int bottomRow = matrix.length - 1;

        while (topRow < bottomRow) {
            int[] temp = matrix[topRow];
            matrix[topRow++] = matrix[bottomRow];
            matrix[bottomRow--] = temp;
        }

        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < m; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
}
