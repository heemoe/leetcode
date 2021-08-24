export class Solution {
  /**
   * mergeSortedArray
   *
   * @param A: sorted integer array A
   * @param B: sorted integer array B
   * @return: A new sorted integer array
   */
  mergeSortedArray(A, B) {
    // write your code here
    let p1 = A.length - 1,
      p2 = B.length - 1,
      tail = A.length + B.length - 1;

    //  找最大的放A的末尾
    let cur;
    while (p1 >= 0 || p2 >= 0) {
      const left = A[p1];
      const right = B[p2];
      // 如果A数组排序完后则排B数组，如果B数组排序完后则排A数组
      if (p1 === -1) {
        cur = B[p2];
        p2--;
      } else if (p2 === -1) {
        cur = A[p1];
        p1--;
      } else if (left > right) {
        cur = left;
        p1--;
      } else {
        cur = right;
        p2--;
      }

      A[tail] = cur;
      tail--;
    }
    return A;
  }
}
const obj = new Solution();
console.log(obj.mergeSortedArray([1, 2, 3, 4], [2, 4, 5, 6]));
