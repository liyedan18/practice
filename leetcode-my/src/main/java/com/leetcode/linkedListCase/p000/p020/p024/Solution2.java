package com.leetcode.linkedListCase.p000.p020.p024;

import com.leetcode.linkedListCase.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * 思路：
 *      方式一：
 *          迭代 画图
 *          时间复杂度：O(N)
 *          空间复杂度：O(1)
 *
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {

        //虚拟头结点
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode temp = vHead;
        while (temp.next != null && temp.next.next != null) {

            ListNode cur = temp.next;
            ListNode next = temp.next.next;
            //交换
            temp.next = next;
            cur.next = next.next;
            next.next = cur;
            temp = cur;
        }

        return vHead.next;
    }
}
