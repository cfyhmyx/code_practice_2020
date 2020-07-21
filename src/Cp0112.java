// https://leetcode.com/problems/path-sum/

public class Cp0112 {
    public static void main(String args[]) {

    }

    // Main idea: tree, stack.
    // Time: O(n), n is the number of tree nodes.
    // Space: O(n).
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                return true;
            }
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
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
