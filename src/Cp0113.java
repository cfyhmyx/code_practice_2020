// https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

public class Cp0113 {
    public static void main(String args[]) {

    }

    // Main idea: tree, stack.
    // Time: O(n), n is the number of tree nodes.
    // Space: O(n).
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, sum, list, new ArrayList<>());
        return list;
    }

    private static void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum-root.val == 0) {
            list.add(new ArrayList<>(path));
        }
        helper(root.left, sum-root.val, list, path);
        helper(root.right, sum-root.val, list, path);
        path.remove(path.size()-1);
    }

    // Main idea: tree, stack.
    // Time: O(n^2), n is the number of tree nodes.
    // Space: O(n).
    /*public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
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
