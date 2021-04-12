package com.leetcode.linkedListCase.p000.p020.p025;

import com.leetcode.linkedListCase.ListNode;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * 思路：
 *      可以用递归思想，k个一组具有递归性质
 *      1.先反转前k个节点，返回头结点head(k)
 *          由反转整个链表，也就是head->null，推出反转前k个节点，也就是head->k,[head,k)
 *          这里前提是节点值不重复
 *
 *      2.从k+1开始继续反转，返回头结点head(K+1)
 *      3.将head(k)与head(k+1)连接起来
 *
 *      递归base case
 *          也就是当节点数<k时，不反转的处理
 *
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        //base case,其实是左闭右开
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            //判断不到k个的情况
            if (end == null) {
                return start;
            }
            end = end.next;
        }
        ListNode newHead = reverseAB(start, end);

        //连接下一组反转的链表
        head.next = reverseKGroup(end, k);

        return newHead;
    }

    /**
     * 反转head到end之间的节点，左闭右开
     * 返回反转后的头结点
     */
    private ListNode reverseAB(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode next = head;
        ListNode cur = head;
        while (cur != end) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }

}
