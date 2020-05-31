// https://leetcode.com/problems/as-far-from-land-as-possible/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cp1162 {

    public static void main(String args[]) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int result = maxDistance(grid);
        System.out.println(result);
    }

    // Main idea: bfs
    // Time: O(n^2)
    // Space: O(n^2)
    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = -1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    grid[x][y] = grid[cell[0]][cell[1]] + 1;
                    res = Math.max(grid[x][y], res);
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return res > 0 ? res - 1 : -1;
    }

    // Main idea: dfs
    // Time: O(m*n^2), m = island number.
    // Space: O(n^2)
    /*public static int maxDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid.length];
        for (int i=0; i<distance.length; i++) {
            for (int j=0; j<distance.length; j++) {
                if (grid[i][j] == 0) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, distance, 0);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                result = Math.max(result, distance[i][j]);
            }
        }
        if (result == 0 || result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private static void dfs(int row, int col, int[][] grid, int[][] distance, int step) {
        if (row < 0 || row >= grid.length
                || col < 0
                || col >= grid.length
                || distance[row][col] < step) {
            return;
        }
        distance[row][col] = step;
        dfs(row + 1, col, grid, distance, step + 1);
        dfs(row - 1, col, grid, distance, step + 1);
        dfs(row, col + 1, grid, distance, step + 1);
        dfs(row, col - 1, grid, distance, step + 1);
    }*/
}
