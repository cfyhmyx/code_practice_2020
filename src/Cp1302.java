// https://leetcode.com/problems/deepest-leaves-sum/

import java.util.LinkedList;
import java.util.Queue;

public class Cp1302 {

    public static void main(String args[]) {

    }

    private static int sum;
    private static int maxDepth;

    // Main idea: bfs.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), maximum recursion stack size.
    public static int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public static void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = node.val;
        } else if (depth == maxDepth) {
            sum += node.val;
        }
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }

    // Main idea: bfs.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), maximum stack size.
    /*public static int deepestLeavesSum(TreeNode root) {
        int result = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result = 0;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                result += cur.val;
            }
        }
        return result;
    }*/

    public class TreeNode {
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
