// https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cp0216 {
    public static void main(String args[]) {
        List<List<Integer>> result = combinationSum3(3, 9);
        for (List<Integer> sol : result) {
            for (Integer ele : sol) {
                System.out.print(ele);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(1), since the path cannot have duplicated number.
    // Space: O(1).
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, n, k, result, new LinkedList<>());
        return result;
    }

    private static void backtracking(int start, int n, int k, List<List<Integer>> result, LinkedList<Integer> path) {
        if (k == 0) {
            if (n == 0) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n - i < 0) break;
            path.addLast(i);
            backtracking(i+1, n-i, k-1, result, path);
            path.removeLast();
        }
    }
}
