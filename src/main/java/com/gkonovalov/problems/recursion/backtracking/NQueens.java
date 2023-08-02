package com.gkonovalov.problems.recursion.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/n-queens/">
 *          [Hard][51] - N-Queens
 *      </a>
 * </p>
 * Runtime Complexity: O(n!) for {@code solveNQueens},
 * Space Complexity:   O(n^2) for {@code solveNQueens}.
 */
public class NQueens {

    public static void main(String[] args) {
        System.out.println("N-Queens:" + solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] line : board) {
            Arrays.fill(line, '.');
        }

        backtracking(board, result, 0);

        return result;
    }

    private static void backtracking(char[][] board, List<List<String>> result, int row) {
        if (row == board.length) {
            result.add(prepare(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(board, result, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q') {
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

    private static List<String> prepare(char[][] board) {
        List<String> result = new ArrayList<>();

        for (char[] line : board) {
            result.add(String.valueOf(line));
        }

        return result;
    }
}
