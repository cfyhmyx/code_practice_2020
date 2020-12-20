// https://leetcode.com/problems/count-sorted-vowel-strings/

public class Cp1641 {


    public static void main(String args[]) {
        int result = countVowelStrings(33);
        System.out.println(result);
    }

    // Main idea: dp, dp[i][j], the number of result for length i with at most j different characters.
    // Time: O(n)
    // Space: O(n).
    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
        return dp[n][5];
    }

    // Main idea: backtracking, dfs.
    // Time: O(5^n)
    // Space: O(n).
    /*private static int result = 0;

    public static int countVowelStrings(int n) {
        backtracking(n, 0);
        return result;
    }

    private static void backtracking(int n, int index) {
        if (n == 0) {
            result++;
            return;
        }
        for (int i = index; i < 5; i++) {
            backtracking(n-1, i);
        }
    }*/
}
