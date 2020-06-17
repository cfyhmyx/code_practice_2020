// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

public class Cp1319 {
    private static int[] root;
    private static int[] rank;

    public static void main(String arg[]) {
        int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int result = makeConnected(6, connections);
        System.out.println(result);
    }

    // Main idea: graph, union and find.
    // Time: O(n+m*k) , m is edge number and k is a constant which is less than 5.
    // Space: O(n).
    public static int makeConnected(int n, int[][] connections) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        int available = 0;
        int group = n;
        for (int[] connection : connections) {
            if (union(connection[0], connection[1])) {
                group--;
            } else {
                available++;
            }
        }
        if (group == 1) return 0;
        if (group - 1 > available) return -1;
        return group - 1;
    }

    private static boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2) {
            return false;
        }
        if (rank[root1] >= rank[root2]) {
            root[root2] = root1;
            if (rank[root1] == rank[root2]) {
                rank[root1]++;
            }
        } else {
            root[root1] = root2;
        }
        return true;
    }

    private static int find(int node) {
        if (node == root[node]) {
            return node;
        }
        root[node] = find(root[node]);
        return root[node];
    }
}
