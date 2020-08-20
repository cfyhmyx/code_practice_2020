// https://leetcode.com/problems/decode-ways/

public class Cp0091 {
    public static void main(String args[]) {
        int result = numDecodings("1002");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m).
    // Space: O(m).
    public static int numDecodings(String s) {
        if (s.isEmpty()) return 0;
        int m = s.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[m];
    }
}
