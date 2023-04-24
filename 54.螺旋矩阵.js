/*
 * @lc app=leetcode.cn id=54 lang=javascript
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function (matrix) {
  if (matrix.length == 0) return [];

  let left = 0;
  let right = matrix[0].length - 1;
  let top = 0;
  let bottom = matrix.length - 1;
  let res = [];

  while (left <= right && top <= bottom) {
    for (let i = left; i <= right; i++) {
      res.push(matrix[top][i]);
    }
    top++;
    for (let i = top; i <= bottom; i++) {
      res.push(matrix[i][right]);
    }
    right--;
    if (top <= bottom) {
      for (let i = right; i >= left; i--) {
        res.push(matrix[bottom][i]);
      }
      bottom--;
    }
    if (left <= right) {
      for (let i = bottom; i >= top; i--) {
        res.push(matrix[i][left]);
      }
      left++;
    }
  }

  return res;
};
// @lc code=end
