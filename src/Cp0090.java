// https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp0090 {
    public static void main(String args[]) {
        int[] nums = {1, 2, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
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
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void backtracking(int[] nums, int start, List<List<Integer>> result, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
