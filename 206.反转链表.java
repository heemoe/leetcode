/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            // 下一个遍历的节点 2->3
            ListNode next = curr.next;
            // 下一个节点和当前节点交换
            // 1
            curr.next = pre;
            // 1 -> 2, 1
            pre = curr;
            // curr: 2 -> 3
            curr = next;
        }

        return pre;
    }
}
// @lc code=end
