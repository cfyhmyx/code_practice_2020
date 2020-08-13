// https://leetcode.com/problems/unique-paths/

public class Cp0062 {
    public static void main(String args[]) {
        int result = uniquePaths(3, 2);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m).
    public static int uniquePaths(int m, int n) {
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            rows[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                rows[j] += rows[j - 1];
            }
        }
        return rows[m - 1];
    }
}
