// https://leetcode.com/problems/permutation-sequence/

import java.util.ArrayList;
import java.util.List;

public class Cp0060 {
    public static void main(String args[]) {
        String result = getPermutation(4,9);
        System.out.println(result);
    }

    // Main idea: Math.
    // Time: O(1).
    // Space: O(1).
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i= 1;i<=9;i++) {
            list.add(i);
        }
        String result = "";
        k = k-1;
        for (int i=n-1; i>=0; i--) {
            int factorial = factorial(i);
            int index = k/factorial;
            result += list.get(index);
            list.remove(index);
            k = k%factorial;
        }
        return result;
    }

    private static int factorial(int num) {
        int result = 1;
        while (num > 0) {
            result *= num;
            num--;
        }
        return result;
    }
}
