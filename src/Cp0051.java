// https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.List;

public class Cp0051 {
    public static void main(String args[]) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> path : result) {
            for (String pal : path) {
                System.out.println(pal);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] slash = new boolean[2 * n - 1];   // '/'
        boolean[] backslash = new boolean[2 * n - 1]; // '\'
        List<List<String>> result = new ArrayList<>();
        backtracking(n, col, slash, backslash, result, new char[n][n], 0);
        return result;
    }

    private static void backtracking(int n, boolean[] col, boolean[] slash, boolean[] backslash,
                                     List<List<String>> result, char[][] sol, int rowIndex) {
        if (rowIndex >= n) {
            result.add(convertToString(sol));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (col[colIndex] || slash[rowIndex + colIndex] || backslash[n - 1 + colIndex - rowIndex])
                continue;
            col[colIndex] = true;
            slash[rowIndex + colIndex] = true;
            backslash[n - 1 + colIndex - rowIndex] = true;
            sol[rowIndex][colIndex] = 'Q';
            backtracking(n, col, slash, backslash, result, sol, rowIndex + 1);
            col[colIndex] = false;
            slash[rowIndex + colIndex] = false;
            backslash[n - 1 + colIndex - rowIndex] = false;
            sol[rowIndex][colIndex] = '.';
        }
    }

    private static List<String> convertToString(char[][] sol) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sol.length; i++) {
            String str = "";
            for (int j = 0; j < sol[0].length; j++) {
                if (sol[i][j] != 'Q') {
                    str += '.';
                } else str += 'Q';
            }
            list.add(str);
        }
        return list;
    }
}
