// https://leetcode.com/problems/maximum-subarray/

public class Cp0053 {
    public static void main(String args[]) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n), n is the length of nums.
    // Space: O(1).
    public static int maxSubArray(int[] nums) {
        int result = 0;
        if (nums.length == 0) return result;
        int cur = nums[0];
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur < 0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            result = Math.max(result, cur);
        }
        return result;
    }
}
