package com.gkonovalov.algorithms.math.matrix.multiplication;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * The Strassen Matrix Multiplication algorithm implementation.
 * Strassen's algorithm is a divide-and-conquer method for matrix multiplication.
 * It was developed by Volker Strassen in 1969 and is known for its efficiency
 * compared to the standard matrix multiplication algorithm, especially for large matrices.
 * The standard matrix multiplication algorithm has a time complexity of O(n^3) for multiplying
 * two n x n matrices. Strassen's algorithm, on the other hand, reduces the number of
 * multiplications required, leading to a slightly faster time complexity of approximately O(n^2.81).
 *
 * The key idea behind Strassen's algorithm is to break down the matrix multiplication
 * into a set of recursive subproblems, reducing the number of required multiplications.
 * The algorithm achieves this by expressing the product of two matrices in terms of seven
 * multiplications of smaller matrices, instead of the standard eight multiplications.
 *
 * The Strassen's algorithm follows these steps:
 * Divide: Divide the input matrices A and B into four equal-sized submatrices.
 * Conquer: Recursively compute seven products of smaller matrices using the
 * submatrices obtained in the previous step.
 * Combine: Combine the results of the seven products to obtain the final product of the original matrices.
 *
 * The formula for the recursive step involves computing four new matrices P1, P2, P3, and P4:
 *
 * P1 = A11 * (B12 - B22)
 * P2 = (A11 + A12) * B22
 * P3 = (A21 + A22) * B11
 * P4 = A22 * (B21 - B11)
 *
 * Then, using these intermediate matrices, we can compute the final product matrices C11, C12, C21, and C22:
 *
 * C11 = P1 + P2 - P4
 * C12 = P4 + P3
 * C21 = P2 + P3
 * C22 = P1 + P4 - P3
 *
 * The Strassen's algorithm is widely used in practice for large matrices where the
 * reduced number of multiplications results in noticeable efficiency improvements.
 * However, for small matrices, the standard algorithm might still be more efficient
 * due to the overhead introduced by the recursive decomposition and additional
 * additions required in the Strassen's algorithm.
 * </p>
 * Runtime Complexity: O(n^2.81).
 * Space Complexity:   O(m * n).
 */
public class MatrixStrassenMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        if (n == 1) {
            int[][] result = new int[1][1];

            result[0][0] = A[0][0] * B[0][0];

            return result;
        }

        int newSize = n / 2;
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];
        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        splitMatrix(A, A11, A12, A21, A22);
        splitMatrix(B, B11, B12, B21, B22);

        int[][] P1 = multiply(addMatrices(A11, A22), addMatrices(B11, B22));
        int[][] P2 = multiply(addMatrices(A21, A22), B11);
        int[][] P3 = multiply(A11, subtractMatrices(B12, B22));
        int[][] P4 = multiply(A22, subtractMatrices(B21, B11));
        int[][] P5 = multiply(addMatrices(A11, A12), B22);
        int[][] P6 = multiply(subtractMatrices(A21, A11), addMatrices(B11, B12));
        int[][] P7 = multiply(subtractMatrices(A12, A22), addMatrices(B21, B22));

        int[][] C11 = subtractMatrices(addMatrices(addMatrices(P1, P4), P7), P5);
        int[][] C12 = addMatrices(P3, P5);
        int[][] C21 = addMatrices(P2, P4);
        int[][] C22 = subtractMatrices(addMatrices(addMatrices(P1, P3), P6), P2);

        int[][] result = new int[n][n];

        joinMatrices(C11, C12, C21, C22, result);

        return result;
    }

    private void splitMatrix(int[][] original, int[][] part1, int[][] part2, int[][] part3, int[][] part4) {
        int newSize = original.length / 2;

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                part1[i][j] = original[i][j];
                part2[i][j] = original[i][j + newSize];
                part3[i][j] = original[i + newSize][j];
                part4[i][j] = original[i + newSize][j + newSize];
            }
        }
    }

    private void joinMatrices(int[][] part1, int[][] part2, int[][] part3, int[][] part4, int[][] result) {
        int newSize = part1.length;

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                result[i][j] = part1[i][j];
                result[i][j + newSize] = part2[i][j];
                result[i + newSize][j] = part3[i][j];
                result[i + newSize][j + newSize] = part4[i][j];
            }
        }
    }

    private static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    private int[][] subtractMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }

        return result;
    }
}
