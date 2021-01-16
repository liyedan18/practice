package com.leetcode.linkedListCase.p000.p090.p092;

import com.leetcode.linkedListCase.ListNode;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * 思路：
 *      用递归
 *      先由递归反转整个链表 ——> 递归反转前n个元素 ——> 递归反转部分元素
 *      m=1时，也就变成了反转前n个元素
 */
public class Solution2 {

    /**
     * 递归反转m到n的节点
     * 方法定义：
     *      输入头结点和要反转的起始节点m和结束节点n，返回反转后的头结点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //base case,m==1,相当于反转前n个节点
        if (m == 1) {
            return reverseTopN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 递归反转整个链表
     * 方法定义：
     *      输入链表头head，输出反转后链表的头结点
     */
    private ListNode reverseAll(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseAll(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 递归反转前n个节点
     * 方法定义：
     *      输入链表头结点和要反转的前n个，输出反转后的链表头结点
     *      1<=n<=length
     */
    //base case, 需要记录后继节点
    private ListNode successor = null;

    private ListNode reverseTopN(ListNode head, int n) {
        //base case
        // if (head == null || head.next == null || n ==1){
        //     return head;
        // }

        //base case, 需要记录后继节点(也就是n=1时，指的下一个节点，是不是null都可以)
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode newHead = reverseTopN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next =  new ListNode(2);
        list.next.next =  new ListNode(3);
        list.next.next.next =  new ListNode(4);
        list.next.next.next.next =  new ListNode(5);
        Solution2 s = new Solution2();
        s.reverseBetween(list, 2, 4);
    }
}
