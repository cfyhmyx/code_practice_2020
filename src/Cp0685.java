// https://leetcode.com/problems/redundant-connection-ii/

import java.util.HashMap;
import java.util.Map;

public class Cp0685 {
    public static void main(String args[]) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] result = findRedundantDirectedConnection(edges);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // For the direct graph, we don't need the rank map, since all the parents nodes are predefined.
    //private static Map<Integer, Integer> rank = new HashMap<>();

    // Root map is used to save the root node for find method path compression.
    private static Map<Integer, Integer> rootMap = new HashMap<>();

    // Main idea: union and find
    // Time: O(k*log(n)), k: edges, n: nodes
    // Space: O(n), n: nodes
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        // Parent map is used to save the direct parent node. By using it, we could get
        // the redundant edge candidates.
        Map<Integer, Integer> parentMap = new HashMap<>();
        // Initial the two possible redundant edges.
        int[] candidate1 = null;
        int[] candidate2 = null;
        for (int[] edge : edges) {
            if (!parentMap.containsKey(edge[0])) {
                parentMap.put(edge[0], edge[0]);
            }
            // For the second element in the edge, if it already has parent,
            // then one of its parent node is the redundant.
            if (!parentMap.containsKey(edge[1]) || parentMap.get(edge[1]) == edge[1]) {
                parentMap.put(edge[1], edge[0]);
            } else if (parentMap.get(edge[1]) != edge[1]) {
                candidate1 = new int[]{parentMap.get(edge[1]), edge[1]};
                candidate2 = new int[]{edge[0], edge[1]};
                // Mark the current edge. In the next loop, if all nodes could be united,
                // then the current edge is redundant. Otherwise, the previous edge is
                // redundant.
                edge[0] = -1;
                edge[1] = -1;
            }
        }
        for (int[] edge : edges) {
            // Skip the marked edge.
            if (edge[0] < 0 && edge[1] < 0) {
                continue;
            }
            if (!rootMap.containsKey(edge[0])) {
                rootMap.put(edge[0], edge[0]);
            }
            if (!rootMap.containsKey(edge[1])) {
                rootMap.put(edge[1], edge[1]);
            }
            if (!union(edge[0], edge[1])) {
                // Used to handle the circle graph case.
                return candidate1 == null ? edge : candidate1;
            }
        }
        return candidate2;
    }

    private static boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        // They are already in the same group.
        if (parent1 == parent2) {
            return false;
        }
        rootMap.put(parent2, parent1);
        return true;
    }

    private static int find(int node) {
        if (node == rootMap.get(node)) {
            return node;
        }
        int root = find(rootMap.get(node));
        return root;
    }
}
