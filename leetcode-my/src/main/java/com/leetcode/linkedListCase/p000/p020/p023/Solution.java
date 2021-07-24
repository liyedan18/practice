package com.leetcode.linkedListCase.p000.p020.p023;

import com.leetcode.linkedListCase.ListNode;

/**
 * 23. 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 *
 * 思路：
 *       每次比较开头元素即可。
 *      如何比较所有的开头元素？
 *      合并两个排序链表啥情况，然后转换为
 *
 *      时间复杂度：
 *          在第k次合并后，链表长度为k*n，此时的时间复杂度是 (（1+k）*k/2 )*n =k*k*N
 *      空间复杂度：O(1)
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        if (lists.length == 0) {
            return null;
        }

        for (int i = 0; i < lists.length; i++) {
            //返回的是头结点
            res = mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        //base case
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        //虚拟头结点，保留头指针
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            }
        }
        temp.next = node1 == null ? node2 : node1;

        return res.next;
    }
}
