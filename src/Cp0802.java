// https://leetcode.com/problems/find-eventual-safe-states/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp0802 {

    public static void main(String args[]) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> result = eventualSafeNodes(graph);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    enum Color {
        White, Grey, Black;
    }

    // Main idea: graph, dfs, color set. White: haven't been visited. Grey: visiting. Black: visited
    // Time: O(V+E).
    // Space: O(V).
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph.length == 0) return res;

        Color[] color = new Color[graph.length];
        Arrays.fill(color, Color.White);

        for (int i = 0; i < graph.length; i++) {
            if (!dfsHasCycle(i, graph, color)) res.add(i);
        }

        return res;
    }

    private static boolean dfsHasCycle(int cur, int[][] graph, Color[] color) {
        color[cur] = Color.Grey;

        for (int child : graph[cur]) {
            if (color[child] == Color.Grey) return true;
            if (color[child] == Color.White && dfsHasCycle(child, graph, color)) return true;
        }

        color[cur] = Color.Black;
        return false;
    }
}
