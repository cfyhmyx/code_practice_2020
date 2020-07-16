// https://leetcode.com/problems/recover-binary-search-tree/

public class Cp0099 {
    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node3.left = node1;
        node3.right = node4;
        node4.left = node2;
        recoverTree(node3);
    }

    // Main idea: tree, Morris traversal.
    // Time: O(3*n), n is the number of tree node, and each node will be visited 3 times at most.
    // Space: O(1).
    public static void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode temp = null;
        TreeNode[] candidates = new TreeNode[2];
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.val >= cur.val) {
                    if (candidates[0] == null) {
                        candidates[0] = prev;
                    }
                    candidates[1] = cur;
                }
                prev = cur;
                cur = cur.right;
            } else {
                temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else if (temp.right == cur) {
                    // Recover the tree format.
                    temp.right = null;
                    if (prev != null && prev.val >= cur.val) {
                        if (candidates[0] == null) {
                            candidates[0] = prev;
                        }
                        candidates[1] = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        int tempVal = candidates[0].val;
        candidates[0].val = candidates[1].val;
        candidates[1].val = tempVal;
    }

    // Main idea: tree, recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    /*private static TreeNode prev = null;

    public static void recoverTree(TreeNode root) {
        TreeNode[] candidates = new TreeNode[2];
        helper(root, candidates);
        int temp = candidates[0].val;
        candidates[0].val = candidates[1].val;
        candidates[1].val = temp;
    }

    private static void helper(TreeNode node, TreeNode[] candidates) {
        if (node == null) return;
        helper(node.left, candidates);
        if (prev != null && node.val <= prev.val) {
            if (candidates[0] == null) {
                candidates[0] = prev;
            }
            candidates[1] = node;
        }
        prev = node;
        helper(node.right, candidates);
    }*/

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
