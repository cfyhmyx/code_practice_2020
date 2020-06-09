// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cp0144 {

    public static void main(String args[]) {
        Cp0094.TreeNode n1 = new Cp0094.TreeNode(1);
        Cp0094.TreeNode n2 = new Cp0094.TreeNode(2);
        Cp0094.TreeNode n3 = new Cp0094.TreeNode(3);
        Cp0094.TreeNode n4 = new Cp0094.TreeNode(4);
        Cp0094.TreeNode n5 = new Cp0094.TreeNode(5);
        Cp0094.TreeNode n6 = new Cp0094.TreeNode(6);
        Cp0094.TreeNode n7 = new Cp0094.TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<Integer> result = preorderTraversal(n1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    // Main idea: Morris Traversal.
    // Time: O(3*n), n is the number of tree node, and each node will be visited 3 times at most.
    // Space: O(1).
    public static List<Integer> preorderTraversal(TreeNode root) {
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
                    result.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                } else if (prev.right == cur) {
                    // Recover the tree format.
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    // Main idea: stack.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), maximum stack size.
    /*public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            if(root != null) {
                s.push(root.right);
                result.add(visit.val);
                root = root.left;
            } else if(s.empty()) {
                break;
            } else {
                root = s.pop();
            }
        }
        return result;
    }*/

    // Main idea: recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), recursion stack size.
    /*public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private static void helper(TreeNode root, List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        helper(root.left, result);
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
