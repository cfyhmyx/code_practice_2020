// https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class Cp0104 {
    public static void main(String args[]) {

    }

    // Main idea: tree, recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
