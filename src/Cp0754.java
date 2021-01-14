// https://leetcode.com/problems/reach-a-number/

import java.util.LinkedList;
import java.util.Queue;

public class Cp0754 {
    public static void main(String args[]) {
        int result = reachNumber(5);
        System.out.println(result);
    }

    // Main idea: math.
    // Time: O(sqrt(n)).
    // Space: O(1).
    public static int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) sum += (++step);
        int dis = sum - target;
        if (dis % 2 == 0) return step;
        return step + 1 + (step % 2);
    }
}
