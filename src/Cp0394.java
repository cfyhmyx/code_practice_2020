// https://leetcode.com/problems/decode-string/

import java.util.Stack;

public class Cp0394 {
    public static void main(String args[]) {
        String result = decodeString("2[abc]3[cd]ef");
        System.out.println(result);
    }

    // Main idea: stack, (more concise).
    // Time: O(n), n is the length of string s.
    // Space: O(n).
    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) {
                    cur.append(tmp);
                }
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }

    // Main idea: stack.
    // Time: O(n), n is the length of string s.
    // Space: O(n).
    /*public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }*/

    // Cannot handle the number with multiple digit
    /*public static String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        return dfs(s, 0, "", 1, stack);
    }

    private static String dfs(String s, int index, String temp, int times, Stack<Integer> stack) {
        for (int i=index; i<s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                temp += dfs(s, i + 2, "", Integer.parseInt(String.valueOf(ch)), stack);
                i = stack.pop();
            } else if (Character.isAlphabetic(ch)) {
                temp += ch;
            } else if (ch == ']') {
                stack.push(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j<times; j++) {
                    sb.append(temp);
                }
                return sb.toString();
            }
        }
        return temp;
    }*/
}
