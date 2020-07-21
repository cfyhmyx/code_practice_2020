// https://leetcode.com/problems/path-sum-iii/

import java.util.HashMap;

public class Cp0437 {
    public static void main(String args[]) {

    }

    // Main idea: tree, stack.
    // Time: O(n), n is the number of tree nodes.
    // Space: O(n).
    public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> prefixSum = new HashMap();
        // Default prefix value is 0, and 1 time.
        prefixSum.put(0,1);
        return helper(root, 0, sum, prefixSum);
    }

    public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = prefixSum.getOrDefault(currSum - target, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, prefixSum) + helper(root.right, currSum, target, prefixSum);
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return res;
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
