// https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Main idea: dfs, backtracking.
// Time: O(n*2^(n-1)), there are 2^(n-1) ways to split the string, O(n) to check if the string is palindrome.
// Space: O(n), backtracking recursion stack.
public class Cp0131 {
    public static void main(String args[]) {
        List<List<String>> result = partition("aba");
        for (List<String> path : result) {
            for (String pal : path) {
                System.out.print(pal);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking(s, 0, result, new LinkedList<>());
        return result;
    }

    private static void backtracking(String s, int start, List<List<String>> result, LinkedList<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i+start<=s.length(); i++) {
            String candidate = s.substring(start, start+i);
            if (isPalindrome(candidate)) {
                path.add(candidate);
                backtracking(s, start+i, result, path);
                path.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String candidate) {
        if (candidate.isEmpty()) return false;
        int left = 0;
        int right = candidate.length()-1;
        while(left<right) {
            if (candidate.charAt(left) != candidate.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
