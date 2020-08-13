// https://leetcode.com/problems/unique-paths-iii/

public class Cp0980 {
    private static int result = 0;

    public static void main(String args[]) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int result = uniquePathsIII(grid);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(4^(m*n)), m is the length of grid, n is the length of grid[0].
    // Space: O(m * n).
    public static int uniquePathsIII(int[][] grid) {
        int total = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    total++;
                }
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        // total+1 is the step from start to end.
        helper(grid, startRow, startCol, total + 1);
        return result;
    }

    private static void helper(int[][] grid, int row, int col, int total) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] < 0) {
            return;
        }
        if (grid[row][col] == 2) {
            if (total == 0) {
                result++;
            }
            return;
        }
        // -2 means visited.
        grid[row][col] = -2;
        helper(grid, row - 1, col, total - 1);
        helper(grid, row + 1, col, total - 1);
        helper(grid, row, col - 1, total - 1);
        helper(grid, row, col + 1, total - 1);
        grid[row][col] = 0;
    }
}
