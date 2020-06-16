// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

import java.util.HashMap;
import java.util.Map;

public class Cp1391 {

    private static int[][][] dir = new int[][][]{
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{-1, 0}, {0, 1}}
    };

    public static void main(String args[]) {
        int[][] path = {{2,4,3}, {6,5,2}};
        boolean result = hasValidPath(path);
        System.out.println(result);
    }

    // Main idea: dfs.
    // Time: O(m*n), m is the grid row number, n is the grid column number.
    // Space: O(m*n), recursion stack.
    public static boolean hasValidPath(int[][] grid) {
        if (grid.length == 0) return false;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, m, n, 0, 0, visited);
    }

    private static boolean dfs(int[][] grid, int m, int n, int row, int col, boolean[][] visited) {
        if (row == m - 1 && col == n - 1) {
            return true;
        }
        visited[row][col] = true;
        for (int[] next : dir[grid[row][col] - 1]) {
            int nextRow = row + next[0];
            int nextCol = col + next[1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                continue;
            }
            // We need to check if the next cell could back to the precious cell.
            // Only in this case, the two cells are connected to each other.
            for (int[] prev : dir[grid[nextRow][nextCol] - 1]) {
                if (nextRow + prev[0] == row && nextCol + prev[1] == col) {
                    if (dfs(grid, m, n, nextRow, nextCol, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
