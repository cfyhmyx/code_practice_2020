// https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class Cp0129 {
    private static int result = 0;

    // Main idea: tree, recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private static void helper(TreeNode root, int tempSum) {
        if (root == null) {
            return;
        }
        tempSum = tempSum * 10 + root.val;
        if (root.left == null  && root.right == null) {
            result += tempSum;
            return;
        }
        helper(root.left, tempSum);
        helper(root.right, tempSum);
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
