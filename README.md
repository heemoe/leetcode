# LeetCode

## 矩阵搜索

类似二分查找特性，从左下角开始查找
小于就往右边一列
大于就往上边一行
同样也可从右上角开始

## 二分查找

- 时间复杂度是 O(logn)，空间复杂度是 O(1)

```js
let left = 0;
let right = nums.length - 1;

while (left < right) {
  let mid = Math.floor((left + right) / 2);
}

return left;
```

## 双指针

- 前后指针
- 相向指针
- 外扩指针

```js
let start = 0;
let end = nums.length - 1;
```
