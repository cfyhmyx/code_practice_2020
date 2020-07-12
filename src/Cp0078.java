// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

public class Cp0078 {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
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
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void backtracking(int[] nums, int start, List<List<Integer>> result, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i+1, result, path);
            path.remove(path.size()-1);
        }
    }
}
