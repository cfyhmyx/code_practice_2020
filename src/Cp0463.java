// https://leetcode.com/problems/island-perimeter/

public class Cp0463 {

    public static void main(String args[]) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int result = islandPerimeter(grid);
        System.out.println(result);
    }

    private static int result = 0;

    // Main idea: dfs
    // Time: O(m*n), m is the grid row number, n is the grid column number.
    // Space: O(m*n)
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) return result;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    return result;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            result++;
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }
}
