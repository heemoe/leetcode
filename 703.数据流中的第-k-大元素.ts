/*
 * @lc app=leetcode.cn id=703 lang=typescript
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start
class KthLargest {
  public nums: number[];
  public k: number;
  constructor(k: number, nums: number[]) {
    this.nums = nums.sort((a, b) => a - b);
    this.k = k;
  }

  add(val: number): number {
    this.nums.push(val);
    return this.nums.sort((a, b) => a - b)[this.k - 1];
  }
}

const kthLargest = new KthLargest(2, [1, 5, 8, 10]);
console.log(kthLargest.add(3)); // 2

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */
// @lc code=end
