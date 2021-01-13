// https://leetcode.com/problems/shopping-offers/

import java.util.ArrayList;
import java.util.List;

public class Cp0638 {
    public static void main(String args[]) {

    }

    // Main idea: backtracking.
    // Time: O(n * recursion times), n is the size of needs.
    // Space: O(Math.max(recursion times, n)).
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return backtracking(price, special, needs, 0);
    }

    private static int backtracking(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (index == special.size()) {
            return calculateRemainingPrice(price, needs);
        }
        int i = 0;
        List<Integer> clone = new ArrayList<>(needs);
        for (; i < special.get(index).size() - 1; i++) {
            int remain = needs.get(i) - special.get(index).get(i);
            if (remain < 0) {
                break;
            } else {
                clone.set(i, remain);
            }
        }
        if (i == special.get(index).size() - 1) {
            return Math.min(special.get(index).get(i) + backtracking(price, special, clone, index),
                    backtracking(price, special, needs, index + 1));
        } else {
            return backtracking(price, special, needs, index + 1);
        }
    }

    private static int calculateRemainingPrice(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }
}
