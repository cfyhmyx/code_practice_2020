// https://leetcode.com/problems/sudoku-solver/

import java.util.HashSet;
import java.util.Set;

public class Cp0037 {
    private static Set<Character>[] rowSets = new Set[9];
    private static Set<Character>[] colSets = new Set[9];
    private static Set<Character>[] boxSets = new Set[9];

    public static void main(String args[]) {
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };

        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(1).
    // Space: O(1).
    public static void solveSudoku(char[][] board) {
        initialSets(board);
        backtracking(board, 0);
    }

    private static boolean backtracking(char[][] board, int index) {
        if (index == 81) return true;
        int row = index / 9;
        int col = index % 9;
        if (board[row][col] == '.') {
            for (Character ch = '1'; ch <= '9'; ch++) {
                if (!rowSets[row].contains(ch) && !colSets[col].contains(ch) && !boxSets[(row / 3) * 3 + col / 3].contains(ch)) {
                    rowSets[row].add(ch);
                    colSets[col].add(ch);
                    boxSets[(row / 3) * 3 + col / 3].add(ch);
                    board[row][col] = ch;
                    if (backtracking(board, index+1)) {
                        return true;
                    }
                    rowSets[row].remove(ch);
                    colSets[col].remove(ch);
                    boxSets[(row / 3) * 3 + col / 3].remove(ch);
                    board[row][col] = '.';
                }
            }
        } else {
            return backtracking(board, index+1);
        }
        return false;
    }

    private static void initialSets(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (rowSets[i] == null) {
                    rowSets[i] = new HashSet<>();
                }
                if (colSets[j] == null) {
                    colSets[j] = new HashSet<>();
                }
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxSets[boxIndex] == null) {
                    boxSets[boxIndex] = new HashSet<>();
                }
                if (board[i][j] != '.') {
                    rowSets[i].add(board[i][j]);
                    colSets[j].add(board[i][j]);
                    boxSets[boxIndex].add(board[i][j]);
                }
            }
        }
    }
}
