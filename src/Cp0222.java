// https://leetcode.com/problems/count-complete-tree-nodes/

public class Cp0222 {
    // Main idea: tree, recursion.
    // Time: O(log(n) * log(n)), n is the number of tree node. h + (h-1) + (h-2) +...+ 1, h is the tree height.
    // Space: O(log(n)).
    public static int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private static int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private static int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
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
