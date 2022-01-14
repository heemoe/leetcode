/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowMax = 0, result = 0, n = nums.length;

        for (int i = 0; i < k; i++) {
            windowMax += nums[i];
        }

        result = windowMax;

        for (int i = k; i < n; i++) {
            windowMax = windowMax - nums[i - k] + nums[i];
            result = Math.max(windowMax, result);
        }

        return 1.0 * result / k;
    }
}
// @lc code=end
