package com.gkonovalov.problems.arrays.matrix;

/**
 * Created by Georgiy Konovalov on 14/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/game-of-life/">
 *          [Medium][289] - Game of Life
 *      </a>
 * </p>
 * Runtime Complexity: O(mn) for {@code gameOfLife}.
 * Space Complexity:   O(1) for {@code gameOfLife}.
 */
public class GameOfLife {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0},
                {0, 1}
        };

        gameOfLife(arr);
    }

    public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        final int deadWasLive = 2;
        final int liveWasDead = 3;

        int[][] pos = {{0, 1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                int cell = board[row][col];
                int live = 0;

                for (int[] p : pos) {
                    int r = row + p[0];
                    int c = col + p[1];

                    if (isValid(board, r, c)) {
                        switch (board[r][c]) {
                            case 1:
                            case deadWasLive:
                                live++;
                                break;
                        }
                    }
                }

                if (cell == 1 && (live < 2 || live > 3)) {
                    board[row][col] = deadWasLive;
                } else if (cell == 0 && live == 3) {
                    board[row][col] = liveWasDead;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                board[row][col] %= 2;
            }
        }
    }

    public static void gameOfLife2(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = board[i].clone();
        }

        int[][] pos = {{0, 1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                int cell = copy[row][col];
                int live = 0;

                for (int[] p : pos) {
                    int r = row + p[0];
                    int c = col + p[1];

                    if (isValid(copy, r, c) && copy[r][c] == 1) {
                        live++;
                    }
                }

                if (cell == 1 && (live < 2 || live > 3)) {
                    board[row][col] = 0;
                } else if (cell == 0 && live == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length) {
            return false;
        }
        return true;
    }
}
