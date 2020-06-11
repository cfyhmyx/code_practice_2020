// https://leetcode.com/problems/binary-tree-coloring-game/

public class Cp1145 {

    private static int left = 0;
    private static int right = 0;

    public static void main(String args[]) {

    }

    // Main idea: tree, dfs.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int parent = n - (1 + left + right);
        return Math.max(parent, Math.max(left, right)) > (n / 2);
    }

    private static int dfs(TreeNode node, int x) {
        if (node == null) return 0;
        int curLeft = dfs(node.left, x);
        int curRight = dfs(node.right, x);
        if (node.val == x) {
            left = curLeft;
            right = curRight;
        }
        return 1 + curLeft + curRight;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
