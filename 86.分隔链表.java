/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode p1 = left;
        ListNode p2 = right;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        p1.next = right.next;

        return left.next;

    }
}
// @lc code=end
