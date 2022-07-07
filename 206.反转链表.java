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
    // public ListNode reverseList(ListNode head) {
    // ListNode pre = null;
    // ListNode curr = head;

    // while (curr != null) {
    // // 下一个遍历的节点 2->3
    // ListNode next = curr.next;
    // // 下一个节点和当前节点交换
    // // 1
    // curr.next = pre;
    // // 1 -> 2, 1
    // pre = curr;
    // // curr: 2 -> 3
    // curr = next;
    // }

    // return pre;
    // }
    public ListNode reverseList(ListNode head) {

        // 递归的方案感觉这样会好理解点：若是1->2->3->4->5的情况

        // ListNode cur = reverseList(head.next);
        // 可以理解为从2往后的都已经反转好了，现在是1->2<-3<-4<-5,现在只需要把1和后面那些反转就行了，这个cur现在是5

        // head.next.next = head;
        // 可以理解成1的下一个的下一个再指向1，也就是2->1，然后再断开原来1和2之间的线

        // head.next = null;
        // 现在就变成了1<-2<-3<-4<-5 cur一直没变过，返回的这个cur就是新链表的头节点

        // 只是有助于理解

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = reverseList(head.next);

        head.next.next = head;
        // 断节点
        head.next = null;

        return result;
    }

}
// @lc code=end
