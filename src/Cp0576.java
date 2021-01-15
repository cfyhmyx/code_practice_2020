// https://leetcode.com/problems/out-of-boundary-paths/

public class Cp0576 {
    public static void main(String args[]) {
        int result = findPaths(2, 2, 2, 0, 0);
        System.out.println(result);
    }

    private static int mod = 1000000000 + 7;

    // Main idea: dfs with memorization.
    // Time: O(m*n*N).
    // Space: O(m*n*N).
    public static int findPaths(int m, int n, int N, int i, int j) {
        Long[][][] dp = new Long[m][n][N + 1];
        return (int) dfs(m, n, N, i, j, dp);
    }

    private static long dfs(int m, int n, int N, int row, int col, Long[][][] dp) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (dp[row][col][N] != null) {
            return dp[row][col][N];
        }
        long sum = dfs(m, n, N - 1, row - 1, col, dp) % mod + dfs(m, n, N - 1, row + 1, col, dp) % mod
                + dfs(m, n, N - 1, row, col - 1, dp) % mod + dfs(m, n, N - 1, row, col + 1, dp) % mod;
        sum %= mod;
        dp[row][col][N] = sum;
        return sum;
    }
}
