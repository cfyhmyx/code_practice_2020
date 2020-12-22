// https://leetcode.com/problems/minimum-incompatibility/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cp1681 {

    private static int setSize = 0;
    private static int result = Integer.MAX_VALUE;

    public static void main(String args[]) {
        int[] nums = {5, 3, 3, 6, 3, 3};
        int result = minimumIncompatibility(nums, 4);
        System.out.println(result);
    }

    // Main idea: dfs, backtracking.
    // Time: Unknown.
    // Space: O(n).
    public static int minimumIncompatibility(int[] nums, int k) {
        setSize = nums.length / k;
        List<MySet> sets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sets.add(new MySet());
        }
        backtracking(nums, sets, 0, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static void backtracking(int[] nums, List<MySet> sets, int index, int incompatibility) {
        if (index == nums.length) {
            result = Math.min(result, incompatibility);
            return;
        }

        Set<Integer> visited = new HashSet<>();

        for (MySet curSet : sets) {
            if (!visited.contains(curSet.hashKey) && curSet.set.size() < setSize && !curSet.set.contains(nums[index])) {
                curSet.set.add(nums[index]);
                int oldMinValue = curSet.minValue;
                int oldMaxValue = curSet.maxValue;
                curSet.minValue = Math.min(curSet.minValue, nums[index]);
                curSet.maxValue = Math.max(curSet.maxValue, nums[index]);
                curSet.hashKey |= (1 << nums[index]);

                int diff = getIncompatibilityDiff(oldMinValue, oldMaxValue, curSet.minValue, curSet.maxValue);
                if (incompatibility + diff < result) {
                    backtracking(nums, sets, index + 1, incompatibility + diff);
                }

                curSet.set.remove(nums[index]);
                curSet.minValue = oldMinValue;
                curSet.maxValue = oldMaxValue;
                curSet.hashKey &= ~(1 << nums[index]);
                visited.add(curSet.hashKey);
            }
        }
    }

    private static int getIncompatibilityDiff(int oldMinValue, int oldMaxValue, int minValue, int maxValue) {
        int oldDiff = oldMaxValue <= oldMinValue ? 0 : (oldMaxValue - oldMinValue);
        int diff = maxValue <= minValue ? 0 : (maxValue - minValue);
        return diff - oldDiff;
    }

    public static class MySet {
        public MySet() {
            this.set = new HashSet<>();
            this.maxValue = Integer.MIN_VALUE;
            this.minValue = Integer.MAX_VALUE;
        }

        public int maxValue;
        public int minValue;
        public int hashKey;
        public HashSet<Integer> set;
    }
}


