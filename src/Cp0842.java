// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

import java.util.ArrayList;
import java.util.List;

public class Cp0842 {
    public static void main(String args[]) {
        String S = "8208282164246410656106617222788451072981180819106";
        List<Integer> result = splitIntoFibonacci(S);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    // Main idea: backtracking.
    // Time: O(n^3), n is the length of the num.
    // Space: O(n), largest string (second to string).
    public static List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
        if (n < 3) return new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (Long.parseLong(S.substring(0, i)) > Integer.MAX_VALUE) break;
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (Long.parseLong(S.substring(i, i + j)) > Integer.MAX_VALUE) break;
                List<Integer> candidate = new ArrayList<>();
                if (isValid(i, j, S, candidate)) {
                    return candidate;
                }
            }
        }
        return new ArrayList<>();
    }

    private static boolean isValid(int i, int j, String S, List<Integer> candidate) {
        if (S.charAt(0) == '0' && i > 1) return false;
        if (S.charAt(i) == '0' && j > 1) return false;
        int first = Integer.parseInt(S.substring(0, i));
        int second = Integer.parseInt(S.substring(i, i + j));
        candidate.add(first);
        candidate.add(second);
        for (int start = i + j; start < S.length(); start += String.valueOf(second).length()) {
            if (second > Integer.MAX_VALUE - first) return false;
            second = second + first;
            first = second - first;
            candidate.add(second);
            if (!S.startsWith(String.valueOf(second), start)) return false;
        }
        return true;
    }
}
