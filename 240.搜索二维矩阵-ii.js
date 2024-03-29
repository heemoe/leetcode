/*
 * @lc app=leetcode.cn id=240 lang=javascript
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  // 从左下角开始
  let row = matrix.length - 1;
  let col = 0;

  for (; row >= 0 && col < matrix[0].length; ) {
    if (matrix[row][col] === target) {
      return true;
    } else if (matrix[row][col] > target) {
      row--;
    } else {
      col++;
    }
  }
};
// @lc code=end
