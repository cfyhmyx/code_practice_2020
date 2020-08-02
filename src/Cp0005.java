// https://leetcode.com/problems/longest-palindromic-substring/

public class Cp0005 {
    public static void main(String args[]) {
        String result = longestPalindrome("abcba");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n^2).
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int maxLength = 0;
        String result = "";
        int n = s.length();
        // dp[i][j] indicates whether s[i] to s[j] is palindromic string.
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((len <= 3) || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLength) {
                    maxLength = len;
                    result = s.substring(i, i + len);
                }
            }
        }
        return result;
    }
}
