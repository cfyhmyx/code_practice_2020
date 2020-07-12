// https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp0047 {
    public static void main(String args[]) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        for (List<Integer> path : result) {
            for (int pal : path) {
                System.out.print(pal);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!).
    // Space: O(n).
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new boolean[nums.length], result, new ArrayList<>());
        return result;
    }

    private static void backtracking(int[] nums, boolean[] visited, List<List<Integer>> result,
                                     ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            path.add(nums[i]);
            backtracking(nums, visited, result, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
