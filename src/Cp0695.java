// https://leetcode.com/problems/max-area-of-island/

public class Cp0695 {

    public static void main(String args[]) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int result = maxAreaOfIsland(grid);
        System.out.println(result);
    }

    // Main idea: dfs
    // Time: O(m*n), m is the grid row number, n is the grid column number.
    // Space: O(m*n)
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int result = 0;
        if (m == 0) return result;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, visited);
                    result = Math.max(area, result);
                }
            }
        }
        return result;
    }

    private static int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int n1 = dfs(grid, row - 1, col, visited);
        int n2 = dfs(grid, row + 1, col, visited);
        int n3 = dfs(grid, row, col - 1, visited);
        int n4 = dfs(grid, row, col + 1, visited);

        return 1 + n1 + n2 + n3 + n4;
    }
}
