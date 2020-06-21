// https://leetcode.com/problems/additive-number/

import java.math.BigInteger;

public class Cp0306 {
    public static void main(String args[]) {
    }

    // Main idea: backtracking.
    // Time: O(n^3), n is the length of the num.
    // Space: O(n), largest BigInteger.
    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        // i is the first number length, j is the second number length.
        for (int i = 1; i <= n / 2; ++i)    // O(n)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)   // O(n)
                if (isValid(i, j, num)) return true;
        return false;
    }

    // O(n)
    private static boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        BigInteger first = new BigInteger(num.substring(0, i));
        BigInteger second = new BigInteger(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            second = second.add(first);
            first = second.subtract(first);
            sum = second.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}
