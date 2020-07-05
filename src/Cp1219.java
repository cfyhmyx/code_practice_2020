// https://leetcode.com/problems/path-with-maximum-gold/

public class Cp1219 {
    private static int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String args[]) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int result = getMaximumGold(grid);
        System.out.println(result);
    }

    // Main idea: dfs, backtracking.
    // Time: O(4^k), k is the number of gird with gold.
    // Space: O(k), backtracking recursion stack.
    public static int getMaximumGold(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int gold = backtracking(grid, i, j);
                result = Math.max(result, gold);
            }
        }
        return result;
    }

    private static int backtracking(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        int gold = 0;
        int originalValue = grid[row][col];
        // Visited.
        grid[row][col] = 0;
        for (int[] dir : directions) {
            gold = Math.max(gold, originalValue + backtracking(grid, row + dir[0], col + dir[1]));
        }
        grid[row][col] = originalValue;
        return gold;
    }
}
