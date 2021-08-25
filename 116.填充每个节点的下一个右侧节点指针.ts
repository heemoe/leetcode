/*
 * @lc app=leetcode.cn id=116 lang=typescript
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/**
 * Definition for Node.
 * class Node {
 *     val: number
 *     left: Node | null
 *     right: Node | null
 *     next: Node | null
 *     constructor(val?: number, left?: Node, right?: Node, next?: Node) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

interface Node {
  val: number;
  left: Node;
  right: Node;
  next: Node;
}

function connect(root: Node | null): Node | null {
  if (!root) return null;
  if (!root.left || !root.right) {
    root.next = null;
  }
  connectWith(root.left, root.right);

  return root;
}

function connectWith(left: Node, right: Node) {
  if (!left || !right) return;

  left.next = right;

  connectWith(left.left, left.right);
  connectWith(right.left, right.right);
  connectWith(left.right, right.left);
}
// @lc code=end
