// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class Cp0124 {
    private static int sum = Integer.MIN_VALUE;

    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        int result = maxPathSum(node1);
        System.out.println(result);
    }

    // Main idea: tree, recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    public static int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }

    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        sum = Math.max(sum, root.val + left + right);
        return left >= right ? root.val + left : root.val + right;
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
