package com.gkonovalov.problems.recursion.backtracking;


/**
 * Created by Georgiy Konovalov on 12/15/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/n-queens-ii/">
 *          [Hard][52] - N-Queens II
 *      </a>
 * </p>
 * Runtime Complexity: O(n!) for {@code totalNQueens},
 * Space Complexity:   O(n^2) for {@code totalNQueens}.
 */
public class NQueensTwo {

    public static void main(String[] args) {
        System.out.println("N-Queens:" + totalNQueens(4));
    }

    private static int total = 0;

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];

        backtracking(board, 0);

        return total;
    }

    private static void backtracking(char[][] board, int row) {
        if (row == board.length) {
            total++;
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean canPlace(char[][] board, int row, int col) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q' || board[i][col] == 'Q') {
                return false;
            }

            if (row + i < n && col + i < n && board[row + i][col + i] == 'Q') {
                return false;
            }

            if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] == 'Q') {
                return false;
            }

            if (row - i >= 0 && col + i < n && board[row - i][col + i] == 'Q') {
                return false;
            }

            if (row + i < n && col - i >= 0 && board[row + i][col - i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
