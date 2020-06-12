// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp1466 {

    public static void main(String args[]) {
        int[][] grid = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int result = minReorder(6, grid);
        System.out.println(result);
    }

    // Main idea: graph, bfs
    // Time: O(n)
    // Space: O(n)
    public static int minReorder(int n, int[][] connections) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // 1 means the direction is from the current node to adjacent node.
            adj[from].add(new int[]{to, 1});
            // -1 means the direction is from the adjacent node to the current node.
            adj[to].add(new int[]{from, -1});
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (int[] next : adj[cur]) {
                if (!visited[next[0]]) {
                    queue.offer(next[0]);
                    if (next[1] == 1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
