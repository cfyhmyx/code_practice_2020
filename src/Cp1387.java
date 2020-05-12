// https://leetcode.com/problems/sort-integers-by-the-power-value/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Cp1387 {

    public static void main(String args[]) {
        int result = getKth(7, 11, 4);
        System.out.println(result);
    }

    // Key: number, value: steps to 1
    private static Map<Integer, Integer> map = new HashMap<>();

    // Main idea: map, priority queue.
    // Assume the max step from a available number is m.
    // Time: O(k*logk), since we use hashmap, the average calculatePower would be O(1).
    // Space: O(m).
    public static int getKth(int lo, int hi, int k) {
        map.put(1, 0);
        // Maintain a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> calculatePower(a) == calculatePower(b)
                        ? b - a
                        : calculatePower(b) - calculatePower(a)
        );
        for (int i = lo; i <= hi; i++) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    private static int calculatePower(int num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }
        int step = 1 + ((num % 2 == 0) ? calculatePower(num / 2) : calculatePower(num * 3 + 1));
        map.put(num, step);
        return step;
    }
}
