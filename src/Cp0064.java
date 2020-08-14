// https://leetcode.com/problems/minimum-path-sum/

public class Cp0064 {
    public static void main(String args[]) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = minPathSum(grid);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m).
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[] rows = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            rows[i] = sum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    rows[j] += grid[j][i];
                } else {
                    rows[j] = Math.min(rows[j - 1], rows[j]) + grid[j][i];
                }
            }
        }
        return rows[m - 1];
    }
}
