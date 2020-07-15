// https://leetcode.com/problems/validate-binary-search-tree/

public class Cp0098 {
    public static void main(String args[]) {

    }

    // Main idea: tree, recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), recursion stack size.
    public static boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
