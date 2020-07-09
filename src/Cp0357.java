// https://leetcode.com/problems/count-numbers-with-unique-digits/

public class Cp0357 {
    public static void main(String args[]) {
        int result = countNumbersWithUniqueDigits(1);
        System.out.println(result);
    }

    // Main idea: math.
    // Time: O(1).
    // Space: O(1).
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
