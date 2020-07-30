// https://leetcode.com/problems/delete-node-in-a-bst/

public class Cp0450 {
    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node4.left = node1;
        //node4.right = node5;
        //node1.right = node2;
        //node2.right = node3;
        TreeNode node = deleteNode(node4, 4);
        System.out.println(node.val);
    }

    // Main idea: tree, recursion, move branch.
    // Time: O(h), h is the tree height.
    // Space: O(h).
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode successor = root.right;
            while (successor.left != null) successor = successor.left;
            successor.left = root.left;
            TreeNode result = root.right;
            root.left = null;
            root.right = null;
            return result;
        }
        return root;
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
