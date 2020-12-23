// https://leetcode.com/problems/beautiful-arrangement/

import java.util.Arrays;

public class Cp0526 {

    public static void main(String args[]) {
        int result = countArrangement(2);
        System.out.println(result);
    }

    // Main idea: dfs, backtracking with memorization.
    // Time: O(2^n).
    // Space: O(2^n).
    public static int countArrangement(int N) {
        int[] cache = new int[1 << N];
        Arrays.fill(cache, -1);
        return backtracking(N, 1, 0, cache);
    }

    private static int backtracking(int N, int index, int key, int[] cache) {
        if (index > N) {
            return 1;
        }
        if (cache[key] != -1) {
            return cache[key];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (((key >> i) & 1) == 1) continue;
            if (((i + 1) % index == 0) || (index % (i + 1) == 0)) {
                sum += backtracking(N, index + 1, key | (1 << i), cache);
            }
        }
        cache[key] = sum;
        return sum;
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!).
    // Space: O(n).
    /*private static int result = 0;

    public static int countArrangement(int N) {
        backtracking(N, 1, new boolean[N+1]);
        return result;
    }

    private static void backtracking(int N, int index, boolean[] visited) {
        if (index > N) {
            result++;
            return;
        }
        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;
            if ((i%index == 0) || (index%i == 0)) {
                visited[i] = true;
                backtracking(N, index+1, visited);
                visited[i] = false;
            }
        }
    }*/
}
