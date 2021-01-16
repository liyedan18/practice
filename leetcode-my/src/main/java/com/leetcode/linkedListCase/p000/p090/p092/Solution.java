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
 *
 *      直接迭代求解
 *          先for循环找到m位置和m-1的位置（借助辅助头结点），然后for循环从m到n反转链表
 *      也可以用递归方法（类似后续遍历）
 *
 *      或者：
 *          用List
 *          遍历一遍，把元素放入list，然后反转。
 *          最后重新构造链表。
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) {
            return head;
        }

        //辅助头结点，记录m-1位置的节点
        ListNode before = new ListNode(-1);
        before.next = head;
        //辅助节点，记录头结点位置
        ListNode res = before;

        ListNode cur = head;
        //cur指向m节点
        for (int i = 1; i < m ; i++) {
            before = before.next;
            cur = cur.next;
        }

        /**
         * 关键点：对prev的不同情况判断
         */
        ListNode prev = before;
        if (before.next == head){
            //before没有移动，则prev设置为null
            prev = null;
        }

        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        before.next.next = cur;
        before.next = prev;

        return res.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next =  new ListNode(2);
        list.next.next =  new ListNode(3);
        list.next.next.next =  new ListNode(4);
        list.next.next.next.next =  new ListNode(5);
        Solution s = new Solution();
        s.reverseBetween(list, 2, 4);
    }
}
