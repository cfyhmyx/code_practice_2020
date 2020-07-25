// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class Cp0116 {
    // Main idea: tree, stack.
    // Time: O(n), n is the number of tree node.
    // Space: O(1).
    public Node connect(Node root) {
        if (root == null) return null;
        Node cur = root;
        while (cur.left != null) {
            Node tempChild = new Node(0);
            Node currentChild = tempChild;
            while (cur != null) {
                if (cur.left != null) {
                    currentChild.next = cur.left;
                    currentChild = currentChild.next;
                }
                if (cur.right != null) {
                    currentChild.next = cur.right;
                    currentChild = currentChild.next;
                }
                cur = cur.next;
            }
            cur = tempChild.next;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
