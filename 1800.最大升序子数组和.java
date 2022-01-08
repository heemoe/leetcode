/*
 * @lc app=leetcode.cn id=1800 lang=java
 *
 * [1800] 最大升序子数组和
 */

//  [10,20,30,40,50]

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int result = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {

                max += nums[i];

            } else {
                max = nums[i];

            }

            result = max > result ? max : result;
        }
        return result;
    }

}
// @lc code=end
