// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0017 {
    public static void main(String args[]) {
        List<String> result = letterCombinations("23");
        for (String str : result) {
            System.out.println(str);
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(3^m), assume average character number is each key is 3, m is the digits length.
    // Space: O(m), recursion stack.
    public static List<String> letterCombinations(String digits) {
        Map<Character, Character[]> keyBoard = Initialize();
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtracking(digits, keyBoard, result, "", 0);
        return result;
    }

    private static void backtracking(String digits, Map<Character, Character[]> keyBoard, List<String> result, String comb, int index) {
        if (index == digits.length()) {
            result.add(comb);
            return;
        }
        Character ch = digits.charAt(index);
        for (int i=0; i<keyBoard.get(ch).length; i++) {
            backtracking(digits, keyBoard, result, comb+keyBoard.get(ch)[i], index+1);
        }
    }

    private static Map<Character, Character[]> Initialize() {
        Map<Character, Character[]> keyBoard = new HashMap<>();
        keyBoard.put('2', new Character[]{'a', 'b', 'c'});
        keyBoard.put('3', new Character[]{'d', 'e', 'f'});
        keyBoard.put('4', new Character[]{'g', 'h', 'i'});
        keyBoard.put('5', new Character[]{'j', 'k', 'l'});
        keyBoard.put('6', new Character[]{'m', 'n', 'o'});
        keyBoard.put('7', new Character[]{'p', 'q', 'r', 's'});
        keyBoard.put('8', new Character[]{'t', 'u', 'v'});
        keyBoard.put('9', new Character[]{'w', 'x', 'y', 'z'});
        return keyBoard;
    }
}
