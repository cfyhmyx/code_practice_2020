// https://leetcode.com/problems/accounts-merge/

import java.util.*;

public class Cp0721 {
    private static int[] root;
    private static int[] rank;

    public static void main(String args[]) {

    }

    // Main idea: union and find, hashmap.
    // Time: O(S * alpha(S)), S is the sum of all the emails, alpha(S) is around O(1).
    // Space: O(S).
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int m = accounts.size();
        if (m == 0) return new ArrayList<>();
        root = new int[m];
        rank = new int[m];
        for (int i = 0; i < m; i++) {
            root[i] = i;
        }

        // This part is used to union the users if they have the same email.
        Map<String, Integer> emailToUserIndex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToUserIndex.containsKey(email)) {
                    union(emailToUserIndex.get(email), i);
                } else {
                    emailToUserIndex.put(email, i);
                }
            }
        }

        // Group all the emails belonging to the same user.
        Map<Integer, Set<String>> userIndexToEmail = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int root = find(i);
            userIndexToEmail.putIfAbsent(root, new HashSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                userIndexToEmail.get(root).add(accounts.get(i).get(j));
            }
        }

        // Build the final result.
        List<List<String>> result = new ArrayList<>();
        for (int userIndex : userIndexToEmail.keySet()) {
            List<String> emails = new LinkedList<>();
            emails.addAll(userIndexToEmail.get(userIndex));
            Collections.sort(emails);
            // Add user name.
            emails.add(0, accounts.get(userIndex).get(0));
            result.add(emails);
        }
        return result;
    }

    private static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            if (rank[root1] >= rank[root2]) {
                root[root2] = root1;
                if (rank[root1] == rank[root2]) {
                    rank[root1]++;
                }
            } else {
                root[root1] = root2;
            }
        }
    }

    private static int find(int node1) {
        if (node1 == root[node1]) {
            return node1;
        }
        root[node1] = find(root[node1]);
        return root[node1];
    }
}
