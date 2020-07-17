// https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class Cp0111 {
    public static void main(String args[]) {

    }

    // Main idea: tree, stack.
    // Time: O(n), n is nums length.
    // Space: O(n).
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            result++;
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return result;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return result;
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
