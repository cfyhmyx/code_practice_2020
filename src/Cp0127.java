// https://leetcode.com/problems/word-ladder/

import java.util.*;

public class Cp0127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(list);
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    // Main idea: bfs.
    // Time: O(m*n), m is the wordList length, n is average string length.
    // Space: O(m*n), recursion stack.
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty()
                || wordList == null || wordList.isEmpty() || beginWord.length() != endWord.length()) {
            return 0;
        }
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        for (String word : wordList) {
            endSet.add(word);
        }
        endSet.remove(beginWord);
        if (!endSet.contains(endWord)) {
            return 0;
        }
        int step = 1;
        while (!startSet.isEmpty()) {
            Set<String> tempSet = new HashSet<>();
            step++;
            for (String word : startSet) {
                char[] charArr = word.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    Character oldCh = charArr[i];
                    for (Character ch = 'a'; ch <= 'z'; ch++) {
                        if (charArr[i] == ch) continue;
                        charArr[i] = ch;
                        String newStr = String.valueOf(charArr);
                        if (newStr.equals(endWord)) {
                            return step;
                        } else if (endSet.contains(newStr)) {
                            tempSet.add(newStr);
                            endSet.remove(newStr);
                        }
                        charArr[i] = oldCh;
                    }
                }
            }
            startSet = tempSet;
        }
        return 0;
    }
}
