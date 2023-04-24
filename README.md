# LeetCode

## 矩阵搜索

类似二分查找特性，从左下角开始查找
小于就往右边一列
大于就往上边一行
同样也可从右上角开始

## 双指针

- 前后指针
- 相向指针
- 外扩指针

```js
let start = 0;
let end = nums.length - 1;
```

## 双指针: 只有一个输入, 从两端开始遍历

```js
let fn = (arr) => {
  let left = 0,
    ans = 0,
    right = arr.length - 1;

  while (left < right) {
    // 一些根据 letf 和 right 相关的代码补充
    if (CONDITION) {
      left++;
    } else {
      right--;
    }
  }

  return ans;
};
```

## 双指针: 有两个输入, 两个都需要遍历完

```js
let fn = (arr1, arr2) => {
  let i = 0,
    j = 0,
    ans = 0;

  while (i < arr1.length && j < arr2.length) {
    // 根据题意补充代码
    if (CONDITION) {
      i++;
    } else {
      j++;
    }
  }

  while (i < arr1.length) {
    // 根据题意补充代码
    i++;
  }

  while (j < arr2.length) {
    // 根据题意补充代码
    j++;
  }

  return ans;
};
```

## 滑动窗口

```js
let fn = (arr) => {
  let left = 0,
    ans = 0,
    curr = 0;

  for (let right = 0; right < arr.length; right++) {
    // 根据题意补充代码来将 arr[right] 添加到 curr

    while (WINDOW_CONDITION_BROKEN) {
      // 从 curr 中删除 arr[left]
      left++;
    }

    // 更新 ans
  }

  return ans;
};
```

## 构建前缀和

```js
let fn = (arr) => {
  let prefix = [arr[0]];
  for (let i = 1; i < arr.length; i++) {
    prefix.push(prefix[prefix.length - 1] + arr[i]);
  }

  return prefix;
};
```

## 高效的字符串构建

```js
// arr 是一个字符列表
let fn = (arr) => {
  let ans = [];
  for (const c of arr) {
    ans.push(c);
  }

  return ans.join("");
};
let fn = (arr) => {
  let ans = "";
  for (const c of arr) {
    ans += c;
  }

  return ans;
};
/// 在 javascript中，基准测试表明连接使用 += 比使用 .join()更快
```

## 链表: 快慢指针

```js
let fn = (head) => {
  let slow = head;
  let fast = head;
  let ans = 0;

  while (fast && fast.next) {
    // 根据题意补充代码
    slow = slow.next;
    fast = fast.next.next;
  }

  return ans;
};
```

## 反转链表

```js
let fn = (head) => {
  let curr = head;
  let prev = null;
  while (curr) {
    let nextNode = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  return prev;
};
```

## 找到符合确切条件的子数组数

```js
let fn = (arr, k) => {
  let counts = new Map();
  counts.set(0, 1);
  let ans = 0,
    curr = 0;

  for (const num of arr) {
    // 根据题意补充代码来改变 curr
    ans += counts.get(curr - k) || 0;
    counts.set(curr, (counts.get(curr) || 0) + 1);
  }

  return ans;
};
```

## 单调递增栈

可以应用相同的逻辑来维护单调队列

```js
let fn = (arr) => {
  let stack = [];
  let ans = 0;

  for (const num of arr) {
    // 对于单调递减的情况，只需将 > 翻转到 <
    while (stack.length && stack[stack.length - 1] > num) {
      // 根据题意补充代码
      stack.pop();
    }

    stack.push(num);
  }

  return ans;
};
```

## 二叉树: DFS (递归)

```js
let dfs = (root) => {
  if (!root) {
    return;
  }

  let ans = 0;

  // 根据题意补充代码
  dfs(root.left);
  dfs(root.right);
  return ans;
};
```

## 二叉树: DFS (迭代)

```js
let dfs = (root) => {
  let stack = [root];
  let ans = 0;

  while (stack.length) {
    let node = stack.pop();
    // 根据题意补充代码
    if (node.left) {
      stack.push(node.left);
    }
    if (node.right) {
      stack.push(node.right);
    }
  }

  return ans;
};
```

## 二叉树: BFS

```js
let fn = (root) => {
  let queue = [root];
  let ans = 0;

  while (queue.length) {
    let currentLength = queue.length;
    // 做一些当前层的操作

    let nextQueue = [];

    for (let i = 0; i < currentLength; i++) {
      let node = queue[i];
      // 根据题意补充代码
      if (node.left) {
        nextQueue.push(node.left);
      }
      if (node.right) {
        nextQueue.push(node.right);
      }
    }

    queue = nextQueue;
  }

  return ans;
};
```

## 图: DFS (递归)

以下图模板假设节点编号从 0 到 n - 1 ，并且图是以邻接表的形式给出的。根据问题的不同，您可能需要在使用模板之前将输入转换为等效的邻接表。

```js
let fn = (graph) => {
  let dfs = (node) => {
    let ans = 0;
    // 根据题意补充代码
    for (const neighbor of graph[node]) {
      if (!seen.has(neighbor)) {
        seen.add(neighbor);
        ans += dfs(neighbor);
      }
    }

    return ans;
  };

  let seen = new Set([START_NODE]);
  return dfs(START_NODE);
};
```

## 图: DFS (迭代)

```js
let fn = (graph) => {
  let stack = [START_NODE];
  let seen = new Set([START_NODE]);
  let ans = 0;

  while (stack.length) {
    let node = stack.pop();
    // 根据题意补充代码
    for (const neighbor of graph[node]) {
      if (!seen.has(neighbor)) {
        seen.add(neighbor);
        stack.push(neighbor);
      }
    }
  }

  return ans;
};
```

## 图: BFS

```js
let fn = (graph) => {
  let queue = [START_NODE];
  let seen = new Set([START_NODE]);
  let ans = 0;

  while (queue.length) {
    let currentLength = 0;
    let nextQueue = [];

    for (let i = 0; i < currentLength; i++) {
      let node = queue[i];
      // 根据题意补充代码
      for (const neighbor of graph[node]) {
        if (!seen.has(neighbor)) {
          seen.add(neighbor);
          nextQueue.push(neighbor);
        }
      }
    }

    queue = nextQueue;
  }

  return ans;
};
```

## 找到堆的前 k 个元素

js 没有堆

```java
public int[] fn(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(CRITERIA);
    for (int num: arr) {
        heap.add(num);
        if (heap.size() > k) {
            heap.remove();
        }
    }

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
        ans[i] = heap.remove();
    }

    return ans;
}

```

## 二分查找

```js
let fn = (arr, target) => {
  let left = 0;
  let right = arr.length - 1;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] == target) {
      // 根据题意补充代码
      return;
    }
    if (arr[mid] > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  // left 是插入点
  return left;
};
```

## 二分查找: 重复元素，最左边的插入点

```js
let fn = (arr, target) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};
```

## 二分查找: 重复元素，最右边的插入点

```js
let fn = (arr, target) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};
```

## 二分查找: 贪心问题

寻找最小值：

```js
let fn = (arr) => {
  let check = (x) => {
    // 这个函数的具体实现取决于问题
    return BOOLEAN;
  };

  let left = MINIMUM_POSSIBLE_ANSWER;
  let right = MAXMIMUM_POSSIBLE_ANSWER;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (check(mid)) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return left;
};
```

寻找最大值：

```js
let fn = (arr) => {
  let check = (x) => {
    // 这个函数的具体实现取决于问题
    return BOOLEAN;
  };

  let left = MINIMUM_POSSIBLE_ANSWER;
  let right = MAXMIMUM_POSSIBLE_ANSWER;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (check(mid)) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return right;
};
```

## 回溯

```js

let backtrack = (curr, OTHER_ARGUMENTS...) => {
    if (BASE_CASE) {
        // 修改答案
        return;
    }

    let ans = 0;
    for (ITERATE_OVER_INPUT) {
        // 修改当前状态
        ans += backtrack(curr, OTHER_ARGUMENTS...);
        // 撤消对当前状态的修改
    }

    return ans;
}



```

## 动态规划: 自顶向下法

```js
let fn = (arr) => {
  let dp = (STATE) => {
    if (BASE_CASE) {
      return 0;
    }

    if (memo[STATE] != -1) {
      return memo[STATE];
    }

    let ans = RECURRENCE_RELATION(STATE);
    memo[STATE] = ans;
    return ans;
  };

  let memo = ARRAY_SIZED_ACCORDING_TO_STATE;
  return dp(STATE_FOR_WHOLE_INPUT);
};
```

## 构建前缀树（字典树）

```js
// 注意:只有需要在每个节点上存储数据时才需要使用类。
// 否则，您可以只使用哈希映射实现一个前缀树。
class TrieNode {
  constructor() {
    // 你可以将数据存储在节点上
    this.data = null;
    this.children = new Map();
  }
}

let fn = (words) => {
  let root = new TrieNode();
  for (const word of words) {
    let curr = root;
    for (const c of word) {
      if (!curr.children.has(c)) {
        curr.children.set(c, new TrieNode());
      }
      curr = curr.children.get(c);
    }

    // 这个位置上的 curr 已经有一个完整的单词
    // 如果你愿意，你可以在这里执行更多的操作来给 curr 添加属性
  }

  return root;
};
```
