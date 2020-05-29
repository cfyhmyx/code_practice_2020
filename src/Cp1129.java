// https://leetcode.com/problems/shortest-path-with-alternating-colors/

import java.util.*;

public class Cp1129 {

    public static void main(String args[]) {
        int[][] red_edges = {{0, 1}};
        int[][] blue_edges = {{1, 2}};
        int[] result = shortestAlternatingPaths(3, red_edges, blue_edges);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Main idea: graph, bfs, color representation
    // Time: O(V+E).
    // Space: O(V*V).
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] graph = new int[n][n];
        buildGraph(graph, red_edges, blue_edges);

        // Put array to queue, array size is 2, arr[0] is the node number, arr[1] is the color.
        Queue<int[]> queue = new LinkedList<>();

        // The edge from 0 node to others could be any color, so we add the two conditions to the queue.
        queue.offer(new int[]{0, 1});
        queue.offer(new int[]{0, -1});
        int len = 0;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0];
                int color = cur[1];
                int oppositeColor = -color;

                for (int j = 1; j < n; j++) {
                    if (graph[node][j] == oppositeColor || graph[node][j] == 0) {
                        if (!visited.add(j + "" + oppositeColor)) continue;
                        queue.offer(new int[]{j, oppositeColor});
                        res[j] = Math.min(res[j], len);
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }

        return res;
    }

    private static void buildGraph(int[][] graph, int[][] red_edges, int[][] blue_edges) {
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], -graph.length);
        }

        // Mark red edge to be 1.
        for (int[] edge : red_edges) {
            graph[edge[0]][edge[1]] = 1;
        }

        // Mark blue edge to be -1, if the edge has two colors, mark it as 0.
        for (int[] edge : blue_edges) {
            if (graph[edge[0]][edge[1]] == 1) {
                graph[edge[0]][edge[1]] = 0;
            } else {
                graph[edge[0]][edge[1]] = -1;
            }
        }
    }
}
