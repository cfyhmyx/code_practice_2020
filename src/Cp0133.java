//https://leetcode.com/problems/clone-graph/

import java.util.*;

public class Cp0133 {
    public static void main(String args[]) {

    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Main idea: BFS.
    // Time: O(V+E)
    // Space: O(V), the input and returned space will not be counted.
    private static Node cloneGraph_bfs(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node subNode : curNode.neighbors) {
                if (!map.containsKey(subNode)) {
                    Node newNode = new Node(subNode.val);
                    map.put(subNode, newNode);
                    queue.add(subNode);
                }
                map.get(curNode).neighbors.add(map.get(subNode));
            }
        }
        return map.get(node);
    }

    // Main idea: DFS.
    // Time: O(V+E)
    // Space: O(V), the input and returned space will not be counted.
    private static Node cloneGraph_dfs(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        cloneGraph(node, map);
        return map.get(node);
    }

    private static void cloneGraph(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) return;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node subNode : node.neighbors) {
            cloneGraph(subNode, map);
            map.get(node).neighbors.add(map.get(subNode));
        }
        return;
    }
}
