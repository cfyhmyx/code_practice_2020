// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class Cp0108 {
    public static void main(String args[]) {

    }

    // Main idea: tree, recursion.
    // Time: O(n), n is nums length.
    // Space: O(log(n)).
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length);
        return root;
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left >= right) return null;
        int index = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, left, index);
        node.right = helper(nums, index + 1, right);
        return node;
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
