// https://leetcode.com/problems/iterator-for-combination/

import java.util.LinkedList;
import java.util.Queue;

public class Cp1286 {
    public static void main(String args[]) {

    }

    // Main idea: dfs, backtracking.
    // Time: constructor: O(C(n)(k)), next(): O(1), hasNext(): O(1)
    // n is the length of the characters, k is the combinationLength.
    // Space: O(C(n)(k)).
    class CombinationIterator {
        private Queue<String> queue = new LinkedList<>();

        public CombinationIterator(String characters, int combinationLength) {
            if (combinationLength > 0 && !characters.isEmpty()) {
                backtracking(characters, 0, combinationLength, "");
            }
        }

        private void backtracking(String characters, int start, int n, String cur) {
            if (cur.length() == n || start == characters.length()) {
                if (cur.length() == n) {
                    queue.add(cur);
                }
                return;
            }
            for (int i = start; i < characters.length(); i++) {
                if (i > start && characters.charAt(i) == characters.charAt(i - 1)) continue;
                backtracking(characters, i + 1, n, cur + characters.charAt(i));
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
