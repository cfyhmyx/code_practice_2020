// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

import java.util.HashSet;

public class Cp1593 {


    public static void main(String args[]) {
        int result = maxUniqueSplit("aa");
        System.out.println(result);
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!*n), n is the length of the string.
    // Space: O(n).
    private static int result = 0;

    public static int maxUniqueSplit(String s) {
        backtracking(0, s, new HashSet<>());
        return result;
    }

    private static void backtracking(int start, String s, HashSet<String> set) {
        if (start == s.length()) {
            result = Math.max(result, set.size());
            return;
        }
        for (int end = start+1; end <= s.length(); end++) {
            String cur = s.substring(start, end);
            if (set.add(cur)) {
                backtracking(end, s, set);
                set.remove(cur);
            }
        }
    }
}
