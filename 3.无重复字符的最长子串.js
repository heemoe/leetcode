/*
 * @lc app=leetcode.cn id=3 lang=javascript
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let map = {};
  let n = s.length,
    left = 0,
    right = 0,
    result = 0;

  while (right < n) {
    let alpha = s[right];

    if (map.hasOwnProperty(alpha)) {
      left = Math.max(left, map[alpha]);
    }
    map[alpha] = right + 1;
    result = Math.max(result, right - left + 1);
    right++;
  }

  return result;
};
// @lc code=end
