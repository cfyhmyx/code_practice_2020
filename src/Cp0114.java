// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.Stack;

public class Cp0114 {
    public static void main(String args[]) {

    }

    // Main idea: tree, stack.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), maximum stack size.
    public static void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode();
        TreeNode cur = dummy;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root.right);
                cur.right = root;
                cur = cur.right;
                TreeNode temp = root.left;
                root.left = null;
                root.right = null;
                root = temp;
            } else if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }
        }
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
