// https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class Cp0049 {

    public static void main(String args[]) {
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    // Main idea: map.
    // Time: O(m*n), m is the size of strs, n is the average length of strs element.
    // Space: O(m*n).
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] arr = new int[26];
            for(int i = 0;i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new ArrayList<>());
            tempList.add(s);
            map.put(key,tempList);
        }
        return new ArrayList<>(map.values());
    }
}
