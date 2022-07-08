/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode p1 = reversed;
        ListNode p2 = head;

        while (p1 != null &&
                p1.next != null) {

            if (p1.val != p2.val) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode curr = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return curr;
    }
}
// @lc code=end
