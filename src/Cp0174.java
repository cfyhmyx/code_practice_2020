// https://leetcode.com/problems/dungeon-game/

public class Cp0174 {
    public static void main(String args[]) {
        int[][] grid = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int result = calculateMinimumHP(grid);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m).
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] rows = new int[m];
        rows[m - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            rows[i] = Math.max(1, rows[i + 1] - dungeon[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    rows[j] = Math.max(1, rows[j] - dungeon[j][i]);
                } else {
                    rows[j] = Math.max(1, Math.min(rows[j], rows[j + 1]) - dungeon[j][i]);
                }
            }
        }
        return rows[0];
    }
}
