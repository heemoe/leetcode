export class Solution {
  /**
   * kthLargestElement2
   *
   * @param nums: an integer unsorted array
   * @param k: an integer from 1 to n
   * @return: the kth largest element
   */
  kthLargestElement2(nums, k) {
    // write your code here
    let low = 0,
      high = nums.length - 1;
    while (low <= high) {
      let index = low - 1;
      for (let i = low; i < high; i++) {
        if (nums[i] > nums[high]) {
          swap(nums, i, ++index);
        }
      }

      swap(nums, ++index, high);
      if (index == k - 1) {
        return nums[index];
      }
      if (index < k - 1) {
        low = index + 1;
      } else {
        high = index - 1;
      }
    }
    return -1;
  }
}

function swap(nums, l, r) {
  let temp = nums[l];
  nums[l] = nums[r];
  nums[r] = temp;
}
const obj = new Solution();
console.log(obj.kthLargestElement2([9, 3, 2, 4, 8], 3));
4;
