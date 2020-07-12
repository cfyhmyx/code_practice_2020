// https://leetcode.com/problems/n-queens-ii/

public class Cp0052 {
    private static int total = 0;

    public static void main(String args[]) {
        int result = totalNQueens(4);
        System.out.println(result);
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!).
    // Space: O(n).
    public static int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] slash = new boolean[2 * n - 1];   // '/'
        boolean[] backslash = new boolean[2 * n - 1]; // '\'
        backtracking(n, col, slash, backslash, 0);
        return total;
    }

    private static void backtracking(int n, boolean[] col, boolean[] slash, boolean[] backslash,
                                     int rowIndex) {
        if (rowIndex >= n) {
            total++;
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (col[colIndex] || slash[rowIndex + colIndex] || backslash[n - 1 + colIndex - rowIndex])
                continue;
            col[colIndex] = true;
            slash[rowIndex + colIndex] = true;
            backslash[n - 1 + colIndex - rowIndex] = true;
            backtracking(n, col, slash, backslash, rowIndex + 1);
            col[colIndex] = false;
            slash[rowIndex + colIndex] = false;
            backslash[n - 1 + colIndex - rowIndex] = false;
        }
    }
}
