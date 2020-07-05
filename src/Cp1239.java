// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

import java.util.Arrays;
import java.util.List;

public class Cp1239 {
    private static int result = 0;

    public static void main(String args[]) {
        List<String> arr = Arrays.asList("jnfbyktlrqumowxdd", "mvhgcpxnjzrdei");
        int result = maxLength(arr);
        System.out.println(result);
    }

    // Main idea: dfs, backtracking, bitwise operation.
    // Time: O(n!), n is the arr size.
    // Space: O(n).
    public static int maxLength(List<String> arr) {
        if (arr == null || arr.isEmpty()) return 0;
        backtracking(arr, "", 0);
        return result;
    }

    private static void backtracking(List<String> arr, String cur, int start) {
        boolean isUnique = isUnique(cur);
        if (isUnique) {
            result = Math.max(result, cur.length());
        }
        if (start == arr.size() || !isUnique) return;
        for (int i = start; i < arr.size(); i++) {
            if (isUnique(arr.get(i))) {
                backtracking(arr, cur + arr.get(i), i + 1);
            }
        }
    }

    private static boolean isUnique(String candidate) {
        int mask = 0;
        for (char ch : candidate.toCharArray()) {
            if ((mask & (1 << ch - 'a')) != 0) {
                return false;
            }
            mask |= 1 << ch - 'a';
        }
        return true;
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!*m), n is the arr size, m is average string in arr length.
    // Space: O(n*m).
    /*public static int maxLength(List<String> arr) {
        if (arr == null || arr.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        backtracking(arr, set, 0);
        return result;
    }

    private static void backtracking(List<String> arr, Set<Character> set, int start) {
        for (int i = start; i < arr.size(); i++) {
            List<Character> charList = new ArrayList<>();
            for (Character ch : arr.get(i).toCharArray()) {
                charList.add(ch);
            }
            boolean duplicated = false;
            Set<Character> temp = new HashSet<>(set);
            for (Character ch : charList) {
                if (!temp.add(ch)) {
                    duplicated = true;
                    break;
                }
            }
            if (!duplicated) {
                set.addAll(charList);
                result = Math.max(result, set.size());
                backtracking(arr, set, i + 1);
                set.removeAll(charList);
            }
        }
    }*/
}
