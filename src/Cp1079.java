// https://leetcode.com/problems/letter-tile-possibilities/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cp1079 {

    public static void main(String args[]) {
        int result = numTilePossibilities("AAB");
        System.out.println(result);
    }

    private static int result = 0;

    // Main idea: dfs, backtracking.
    // Time: O(n!), n is the length of the tiles.
    // Space: O(n).
    public static int numTilePossibilities(String tiles) {
        char[] list = tiles.toCharArray();
        Arrays.sort(list);
        boolean[] visited = new boolean[list.length];
        dfs(list, 0, visited);
        return result;
    }

    private static void dfs(char[] list, int curLength, boolean[] visited){
        if(curLength == list.length) return;
        for(int i = 0; i < list.length; i++){
            if(visited[i]) continue;
            if(i - 1 >= 0 && list[i] == list[i - 1] && !visited[i - 1]) continue;
            result ++;
            visited[i] = true;
            dfs(list, curLength + 1, visited);
            visited[i] = false;
        }
    }
}
