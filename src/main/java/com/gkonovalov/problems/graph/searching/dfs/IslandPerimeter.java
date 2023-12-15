package com.gkonovalov.problems.graph.searching.dfs;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/island-perimeter/">
 *              [Easy][463] - Island Perimeter
 *      </a>
 * </p>
 * Runtime Complexity: O(m*n) for {@code islandPerimeter}, {@code islandPerimeter2}.
 * Space Complexity:  O(m*n) for {@code islandPerimeter}, O(1) for {@code islandPerimeter2}.
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println("Island perimeter:" + islandPerimeter(arr));
    }

    public static int islandPerimeter(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid, row, col);
                }
            }
        }
        return 0;
    }

    private static int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 1;
        }

        if (grid[row][col] == -1) {
            return 0;
        }

        grid[row][col] = -1;

        return dfs(grid, row + 1, col) +
                dfs(grid, row, col + 1) +
                dfs(grid, row - 1, col) +
                dfs(grid, row, col - 1);
    }

    public static int islandPerimeter2(int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;

                    if (row > 0 && grid[row - 1][col] == 1) {
                        perimeter -= 1;
                    }

                    if (col > 0 && grid[row][col - 1] == 1) {
                        perimeter -= 1;
                    }

                    if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                        perimeter -= 1;
                    }

                    if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                        perimeter -= 1;
                    }
                }
            }
        }
        return perimeter;
    }
}
