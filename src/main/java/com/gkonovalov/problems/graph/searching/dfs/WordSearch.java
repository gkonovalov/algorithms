package com.gkonovalov.problems.graph.searching.dfs;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">
 *          [Medium][79] - Word Search
 *      </a>
 * </p>
 * Runtime Complexity: O(n 3^L) for {@code spiralOrder}, {@code spiralOrder2}.
 * Space Complexity:  O(L) for {@code spiralOrder2} and O(m*n) for {@code spiralOrder}.
 */
public class WordSearch {

    public static void main(String[] args) {
        System.out.println("Word exist:" + exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int pos) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length ||
                pos >= word.length() || board[row][col] != word.charAt(pos)) {
            return false;
        }

        if (pos == word.length() - 1) {
            return true;
        }

        char letter = board[row][col];
        board[row][col] = '.';

        boolean result = dfs(board, word, row + 1, col, pos + 1)
                || dfs(board, word, row, col + 1, pos + 1)
                || dfs(board, word, row, col - 1, pos + 1)
                || dfs(board, word, row - 1, col, pos + 1);

        board[row][col] = letter;
        return result;
    }

}
