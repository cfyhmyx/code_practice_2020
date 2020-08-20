// https://leetcode.com/problems/interleaving-string/

public class Cp0097 {
    public static void main(String args[]) {
        boolean result = isInterleave("aabcc", "dbbca", "aadbbcbccc");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m*n).
    // Space: O(m*n).
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) return false;
        // dp[i][j] means s3 prefix string with length i + j is formed by the interleaving of s1 prefix string with
        // length i and s2 prefix string with length j.
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
