import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cp0305 {
    public static void main(String args[]) {
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        List<Integer> result = numIslands2(3, 3, positions);
        System.out.println(result);
    }

    private static int island = 0;
    private static int[] rank;
    private static Map<Integer, Integer> rootMap = new HashMap<>();

    // Main idea: union and find
    // Time: O(k*log(m*n)), k: the number of positions
    // Space: O(m*n)
    private static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList();
        if (m == 0 || n == 0) return res;
        rank = new int[m * n];
        int[][] step = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] p : positions) {
            int row = p[0], col = p[1];
            int node = row * n + col;
            if (rootMap.containsKey(node)) {
                res.add(island);
                continue;
            }
            rootMap.put(node, node);
            island += 1;
            for (int[] s : step) {
                int i = row + s[0], j = col + s[1];
                int neighbor = i * n + j;
                if (i >= 0 && i < m && j >= 0 && j < n && rootMap.containsKey(neighbor)) {
                    union(node, neighbor);
                }
            }
            res.add(island);
        }
        return res;
    }

    private static int union(int n1, int n2) {
        int root1 = find(n1), root2 = find(n2);
        if (root1 == root2) return root1;
        island--;
        if (rank[root1] >= rank[root2]) {
            rootMap.put(root2, root1);
            if (rank[root1] == rank[root2])
                rank[root1]++;
            return root1;
        } else {
            rootMap.put(root1, root2);
            return root2;
        }
    }

    private static int find(int node) {
        int parent = rootMap.get(node);
        if (node == parent) {
            return node;
        }
        int root = find(parent);
        rootMap.put(node, root);
        return root;
    }
}
