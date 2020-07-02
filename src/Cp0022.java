// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class Cp0022 {
    public static void main(String args[]) {
        List<String> result = generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(2^(2*n)).
    // Space: O(2*n), recursion stack.
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) return result;
        backtracking(2 * n, n, n, result, "");
        return result;
    }

    private static void backtracking(int length, int remainLeft, int remainRight, List<String> result, String cur) {
        if (cur.length() >= length) {
            result.add(cur);
            return;
        }
        if (remainLeft > 0) {
            backtracking(length, remainLeft - 1, remainRight, result, cur + "(");
        }
        if (remainRight > remainLeft) {
            backtracking(length, remainLeft, remainRight - 1, result, cur + ")");
        }
    }
}
