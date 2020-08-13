// https://leetcode.com/problems/unique-paths-ii/

public class Cp0063 {
    public static void main(String args[]) {

    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m).
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            rows[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[j][i] == 1) {
                    rows[j] = 0;
                } else {
                    if (j != 0) {
                        rows[j] += rows[j - 1];
                    }
                }
            }
        }
        return rows[m - 1];
    }
}
