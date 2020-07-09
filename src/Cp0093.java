// https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class Cp0093 {
    public static void main(String args[]) {
        List<String> result = restoreIpAddresses("010010");
        for (String str : result) {
            System.out.println(str);
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(1).
    // Space: O(1).
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(s, 0, 4, result, "");
        return result;
    }

    private static void backtracking(String s, int start, int n, List<String> result, String path) {
        if (start == s.length() || n == 0) {
            if (start == s.length() && n == 0) {
                result.add(path);
            }
            return;
        }
        for (int i = 1; start + i <= s.length(); i++) {
            String temp = s.substring(start, start+i);
            if (temp.length() > 1 && temp.charAt(0) == '0') break;
            if (Integer.parseInt(temp) > 255) break;
            backtracking(s, start+i, n - 1, result, path.isEmpty() ? temp : path + '.' + temp);
        }
    }
}
