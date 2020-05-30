// https://leetcode.com/problems/satisfiability-of-equality-equations/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0990 {

    public static void main(String args[]) {
        String[] equations = {"a!=b","b!=c","c!=a"};
        boolean result = equationsPossible(equations);
        System.out.println(result);
    }

    private static Map<Character, Integer> rankMap = new HashMap<>();
    private static Map<Character, Character> rootMap = new HashMap<>();

    // Main idea: union and find, use both rank and path compression
    // Time: O(n * amortized O(1)), n: equations
    // Space: O(n)
    public static boolean equationsPossible(String[] equations) {
        List<String> unequals = new ArrayList<>();
        for (String equation : equations) {
            if (!rootMap.containsKey(equation.charAt(0))) {
                rootMap.put(equation.charAt(0), equation.charAt(0));
                rankMap.put(equation.charAt(0), 0);
            }
            if (!rootMap.containsKey(equation.charAt(3))) {
                rootMap.put(equation.charAt(3), equation.charAt(3));
                rankMap.put(equation.charAt(3), 0);
            }
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0), equation.charAt(3));
            } else {
                unequals.add(equation);
            }
        }
        for (String equation : unequals) {
            Character rootNode1 = find(equation.charAt(0));
            Character rootNode2 = find(equation.charAt(3));
            if (rootNode1 == rootNode2) {
                return false;
            }
        }
        return true;
    }

    private static boolean union(Character node1, Character node2) {
        Character rootNode1 = find(node1);
        Character rootNode2 = find(node2);
        if (rootNode1 == rootNode2) {
            return false;
        }
        // Union by rank.
        if (rankMap.get(rootNode1) >= rankMap.get(rootNode2)) {
            rootMap.put(rootNode2, rootNode1);
            if (rankMap.get(rootNode1) == rankMap.get(rootNode2)) {
                rankMap.put(rootNode1, rankMap.get(rootNode1) + 1);
            }
        } else {
            rootMap.put(rootNode1, rootNode2);
        }
        return true;
    }

    private static Character find(Character node) {
        if (node == rootMap.get(node)) {
            return node;
        }
        Character rootNode = find(rootMap.get(node));
        // Path compression.
        rootMap.put(node, rootNode);
        return rootNode;
    }
}
