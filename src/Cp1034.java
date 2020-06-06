// https://leetcode.com/problems/coloring-a-border/

public class Cp1034 {
    public static void main(String args[]) {
        int[][] grid = {{1, 1}, {1, 2}};
        int[][] result = colorBorder(grid, 0, 0, 3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Main idea: dfs
    // Time: O(m*n), m is the grid row number, n is the grid column number.
    // Space: O(m*n)
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid.length == 0) return grid;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, grid[r0][c0], color, visited);
        return grid;
    }

    private static boolean dfs(int[][] grid, int row, int col, int originalColor, int newColor, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || (grid[row][col] != originalColor && !visited[row][col])) {
            return true;
        }
        if (visited[row][col]) {
            return false;
        }
        visited[row][col] = true;

        boolean b1 = dfs(grid, row - 1, col, originalColor, newColor, visited);
        boolean b2 = dfs(grid, row + 1, col, originalColor, newColor, visited);
        boolean b3 = dfs(grid, row, col - 1, originalColor, newColor, visited);
        boolean b4 = dfs(grid, row, col + 1, originalColor, newColor, visited);
        // If there is a true means the node is the boarder node.
        if (b1 || b2 || b3 || b4) {
            grid[row][col] = newColor;
        }

        return false;
    }
}
