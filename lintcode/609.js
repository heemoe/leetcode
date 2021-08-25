export class Solution {
  /**
   * twoSum5
   *
   * @param nums: an array of integer
   * @param target: an integer
   * @return: an integer
   */
  twoSum5(nums, target) {
    // write your code here
    let start = 0,
      end = nums.length - 1,
      count = 0;

    nums = nums.sort((a, b) => a - b);

    while (start <= nums.length - 1) {
      while (end >= 0) {
        if (nums[start] + nums[end] > target) {
          end--;
        } else {
          break;
        }
      }

      if (end > start) {
        count += end - start;
      } else {
        break;
      }

      start++;
    }

    return count;
  }
}

const obj = new Solution();
console.log(obj.twoSum5([2, 7, 15, 11], 24));

// 2 7 11 15
//     ^^
