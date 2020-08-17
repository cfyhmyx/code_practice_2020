// https://leetcode.com/problems/scramble-string/

public class Cp0087 {
    public static void main(String args[]) {
        boolean result = isScramble("", "");
        System.out.println(result);
    }

    // Main idea: recursion.
    // Time: O(4^n).
    // Space: O(n).
    public static boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;

        int[] letters = new int[26];
        int len = s1.length();
        for(int i = 0; i < len; i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(letters[i]!= 0) return false;
        }

        for(int i = 1; i < len; i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0,len-i))) return true;
        }
        return false;
    }
}
