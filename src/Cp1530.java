// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

public class Cp1530 {
    private static int result = 0;

    // Main idea: tree, recursion, post-order traversal.
    // Time: O(n*d*d), n is the number of tree node, d is the distance. (not sure)
    // Space: O(d).
    public static int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return result;
    }

    // dis[i], the number of nodes with distance i to the parent node.
    // left[i], the number of nodes with distance i to the current node (left branch).
    // right[i], the number of nodes with distance i to the current node (right branch).
    private static int[] helper(TreeNode root, int distance) {
        if (root == null)
            return new int[distance + 1];
        if (root.left == null && root.right == null) {
            int dis[] = new int[distance + 1];
            dis[1]++;
            return dis;
        }
        int[] left = helper(root.left, distance);
        int[] right = helper(root.right, distance);
        for (int l = 0; l < left.length; l++) {
            for (int r = 0; r < right.length; r++) {
                if (l + r <= distance) {
                    result += left[l] * right[r];
                }
            }
        }
        int dis[] = new int[distance + 1];
        // increase size 1 and shift array to return to the parent level.
        for (int i = dis.length - 2; i >= 1; i--) {
            dis[i + 1] = left[i] + right[i];
        }
        return dis;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
