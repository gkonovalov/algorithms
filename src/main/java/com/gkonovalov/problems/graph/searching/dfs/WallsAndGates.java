package com.gkonovalov.problems.graph.searching.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/walls-and-gates/">
 *          [Medium][286] - Walls and Gates
 *      </a>
 * </p>
 * Runtime Complexity:  O(m*n) for {@code wallsAndGates} and O(m^2 n^2) for {@code wallsAndGatesSlow}.
 * Space Complexity:    O(m*n) for {@code wallsAndGates} and {@code wallsAndGatesSlow}.
 */
public class WallsAndGates {

    public static void main(String[] args) {
        wallsAndGates(new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}});
    }

    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new int[]{row, col});
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int[] newPos : dirs) {
                int r = pos[0] + newPos[0];
                int c = pos[1] + newPos[1];

                if (r < 0 || c < 0 || r >= rooms.length || c >= rooms[0].length || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                }

                rooms[r][c] = rooms[pos[0]][pos[1]] + 1;
                queue.add(new int[]{r, c});
            }
        }
    }

    public static void wallsAndGatesSlow(int[][] rooms) {
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == 0) {
                    dfs(rooms, row, col, 0);
                }
            }
        }
    }

    private static void dfs(int[][] rooms, int row, int col, int counter) {
        if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[row].length || rooms[row][col] < counter) {
            return;
        }

        rooms[row][col] = counter;
        dfs(rooms, row + 1, col, counter + 1);
        dfs(rooms, row, col + 1, counter + 1);
        dfs(rooms, row - 1, col, counter + 1);
        dfs(rooms, row, col - 1, counter + 1);
    }
}
