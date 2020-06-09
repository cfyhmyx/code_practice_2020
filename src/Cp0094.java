// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cp0094 {

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<Integer> result = inorderTraversal(n1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    // Main idea: Morris Traversal.
    // Time: O(3*n), n is the number of tree node, and each node will be visited 3 times at most.
    // Space: O(1).
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode cur = root;
        TreeNode prev;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else if (prev.right == cur) {
                    // Recover the tree format.
                    prev.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    // Main idea: stack.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), maximum stack size.
    /*public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else if(s.empty()) {
                break;
            } else {
                TreeNode visit = s.pop();
                result.add(visit.val);
                root = visit.right;
            }
        }
        return result;
    }*/

    // Main idea: recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), recursion stack size.
    /*public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private static void helper(TreeNode root, List<Integer> result) {
        if(root == null) return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
