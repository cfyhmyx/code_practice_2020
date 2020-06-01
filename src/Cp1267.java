// https://leetcode.com/problems/count-servers-that-communicate/

public class Cp1267 {

    public static void main(String args[]) {
        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int result = countServers(grid);
        System.out.println(result);
    }

    // Main idea: logic
    // Time: O(m*n)
    // Space: O(m+n)
    public static int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int rowCount[] = new int[m];
        int colCount[] = new int[n];
        int totalServers = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                    totalServers++;
                }
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        totalServers--;
                    }
                }
            }
        }
        return totalServers;
    }
}
