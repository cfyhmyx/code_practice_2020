// https://leetcode.com/problems/word-ladder-ii/

import java.util.*;

public class Cp0126 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(list);
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Main idea: bfs.
    // Time: O(m*n), m is the wordList length, n is average string length.
    // Space: O(m*n), recursion stack.
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty()
                || wordList == null || wordList.isEmpty() || beginWord.length() != endWord.length()) {
            return result;
        }
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        for (String word : wordList) {
            endSet.add(word);
        }
        endSet.remove(beginWord);
        if (!endSet.contains(endWord)) {
            return result;
        }
        boolean find = false;
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        while (!startSet.isEmpty()) {
            Set<String> tempSet = new HashSet<>();
            for (String word : startSet) {
                char[] charArr = word.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    Character oldCh = charArr[i];
                    for (Character ch = 'a'; ch <= 'z'; ch++) {
                        if (charArr[i] == ch) continue;
                        charArr[i] = ch;
                        String newWord = String.valueOf(charArr);
                        if (newWord.equals(endWord)) {
                            find = true;
                        }
                        if (endSet.contains(newWord) && !visited.contains(newWord)) {
                            tempSet.add(newWord);
                            List<String> children = graph.getOrDefault(word, new ArrayList<>());
                            children.add(newWord);
                            graph.put(word, children);
                        }
                        charArr[i] = oldCh;
                    }
                }
            }
            if (find) {
                break;
            }
            visited.addAll(tempSet);
            startSet = tempSet;
        }
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(result, path, graph, beginWord, endWord);
        return result;
    }

    private static void dfs(List<List<String>> result, List<String> path, Map<String, List<String>> graph, String beginWord, String endWord) {
        if(beginWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(!graph.containsKey(beginWord)) return;
        for(String start : graph.get(beginWord)) {
            path.add(start);
            dfs(result, path, graph, start, endWord);
            path.remove(path.size()-1);
        }
    }
}
