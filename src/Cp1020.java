// https://leetcode.com/problems/number-of-enclaves/

public class Cp1020 {

    public static void main(String args[]) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int result = numEnclaves(grid);
        System.out.println(result);
    }

    // Main idea: dfs, assume the original matrix A could be modified.
    // Time: O(m*n), m is the grid row number, n is the grid column number.
    // Space: O(m*n), recursion stack.
    public static int numEnclaves(int[][] A) {
        int m = A.length;
        if (m == 0) return 0;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            dfs(A, i, 0);
            dfs(A, i, n-1);
        }
        for (int j = 0; j<n; j++) {
            dfs(A, 0, j);
            dfs(A, m-1, j);
        }
        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (A[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] A, int row, int col) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] != 1) {
            return;
        }
        A[row][col] = 0;
        dfs(A, row-1, col);
        dfs(A, row+1, col);
        dfs(A, row, col-1);
        dfs(A, row, col+1);
    }
}
