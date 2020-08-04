// https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

public class Cp0032 {
    public static void main(String args[]) {
        int result = longestValidParentheses("()((((())))");
        System.out.println(result);
    }

    // Main idea: stack.
    // Time: O(n), n is the length of s.
    // Space: O(n).
    public static int longestValidParentheses(String s) {
        Stack<Integer> left = new Stack<>();
        int lastRight = -1;
        int length = 0;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.push(i);
            } else {
                if(left.empty()) {
                    lastRight = i;
                } else {
                    left.pop();
                    if(left.empty()) {
                        length = Math.max(length, i-lastRight);
                    } else {
                        length = Math.max(length, i-left.peek());
                    }
                }
            }
        }
        return length;
    }

    /*public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new int[]{i, temp});
                temp = 0;
            } else {
                if (!stack.isEmpty()) {
                    int[] arr = stack.pop();
                    temp += arr[1] + 2;
                    result = Math.max(result, temp);
                } else {
                    temp = 0;
                }
            }
        }
        return result;
    }*/
}
