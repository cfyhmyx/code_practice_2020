// https://leetcode.com/problems/validate-stack-sequences/

import java.util.*;

public class Cp0946 {

    public static void main(String args[]) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        boolean result = validateStackSequences(pushed, popped);
        System.out.println(result);
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int ele : pushed) {
            stack.push(ele);
            while (!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
