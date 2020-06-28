// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

import java.util.ArrayList;
import java.util.List;

public class Cp1415 {
    private static int count = 0;
    private static String result = "";

    public static void main(String args[]) {
        String result = getHappyString(10, 100);
        System.out.println(result);
    }

    // Main idea: dfs, backtracking.
    // Time: O(3^n), n is the length of the tiles.
    // Space: O(n), recursion stack size.
    public static String getHappyString(int n, int k) {
        Character[] pool = new Character[]{'a', 'b', 'c'};
        backtracking(pool, n, k, null, "");
        return result;
    }

    private static void backtracking(Character[] pool, int n, int k, Character prev, String happy) {
        if (happy.length() == n) {
            count++;
            if (count == k) {
                result = happy;
            }
            return;
        }
        for (int i = 0; i < pool.length && count < k; i++) {
            if (pool[i] == prev) continue;
            backtracking(pool, n, k, pool[i], happy + pool[i]);
        }
    }

    /*public static String getHappyString(int n, int k) {
        Character[] pool = new Character[]{'a', 'b', 'c'};
        List<String> results = new ArrayList<>();
        backtracking(pool, n, null, "", results);
        if (results.size() < k) {
            return "";
        } else {
            return results.get(k - 1);
        }
    }

    private static void backtracking(Character[] pool, int n, Character prev, String happy, List<String> results) {
        if (happy.length() == n) {
            results.add(happy);
            return;
        }
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] == prev) continue;
            backtracking(pool, n, pool[i], happy + pool[i], results);
        }
    }*/
}
