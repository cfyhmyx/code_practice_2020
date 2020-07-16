// https://leetcode.com/problems/symmetric-tree/

public class Cp0101 {
    public static void main(String args[]) {

    }

    // Main idea: tree, recursion.
    // Time: O(log(n)), n is the number of tree node.
    // Space: O(log(n)).
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 != null && node2 != null && node1.val == node2.val) {
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
        return false;
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
