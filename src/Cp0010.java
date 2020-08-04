// https://leetcode.com/problems/regular-expression-matching/

public class Cp0010 {
    public static void main(String args[]) {
        boolean result = isMatch("ab", ".*");
        System.out.println(result);
    }

    // Main idea: dp, dp[i][j] means s prefix substring with length i matches p prefix substring with length j.
    // Time: O(m * n).
    // Space: O(m * n).
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (j >= 2) && (dp[i][j - 2] || ((i>=1) && (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') && dp[i-1][j]));
                } else {
                    dp[i][j] = (i >= 1) && ((s.charAt(i - 1) == p.charAt(j - 1)) || (p.charAt(j - 1) == '.')) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
