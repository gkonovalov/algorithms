package com.gkonovalov.problems.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/number-of-islands/">
 *          [Medium][200] - Number of Islands
 *      </a>
 * </p>
 * Runtime Complexity: O(m*n) for {@code numIslands}, O(m*n) for {@code numIslandsBfs}.
 * Space Complexity:  O(m*n) for {@code numIslands}, O(min(m,n)) for {@code numIslandsBfs}.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("Islands:" + numIslands(arr));
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != '0') {
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
    }

    public static int numIslandsBfs(char[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    bfsHelper(grid, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void bfsHelper(char[][] grid, int rS, int cS) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{rS, cS});
        grid[rS][cS] = '0';

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int[] newP : dirs) {
                int r = p[0] + newP[0];
                int c = p[1] + newP[1];

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
                    continue;
                }

                grid[r][c] = '0';
                queue.add(new int[]{r, c});
            }
        }
    }
}
