// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp0429 {
    // Main idea: tree, level traversal.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node curNode = queue.poll();
                list.add(curNode.val);
                for (Node node : curNode.children) {
                    queue.offer(node);
                }
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
