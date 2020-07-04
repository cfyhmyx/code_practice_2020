// https://leetcode.com/problems/sequential-digits/

import java.util.ArrayList;
import java.util.List;

public class Cp1291 {
    public static void main(String args[]) {
        List<Integer> result = sequentialDigits(100, 3000000);
        for (Integer num : result) {
            System.out.println(num);
        }
    }

    // Main idea: digit logic.
    // Time: O(1).
    // Space: O(1).
    public static List<Integer> sequentialDigits(int low, int high) {
        String lowStr = String.valueOf(low);
        String highStr = String.valueOf(high);
        List<Integer> result = new ArrayList<>();
        for (int i = lowStr.length(); i <= highStr.length(); i++) {
            generateNumber(i, low, high, result);
        }
        return result;
    }

    private static void generateNumber(int numOfDigit, int low, int high, List<Integer> result) {
        for (int start = 1; start <= 10 - numOfDigit; start++) {
            int candidate = 0;
            int num = start;
            for (int i = 0; i < numOfDigit; i++) {
                candidate = candidate * 10 + num;
                num++;
            }
            if (candidate >= low && candidate <= high) {
                result.add(candidate);
            }
        }
    }
}
