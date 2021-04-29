package com.leetcode.linkedListCase.p000.p010.p019;

import com.leetcode.linkedListCase.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 * 思路：
 *      快慢指针，快指针先走n步，然后慢指针开始走，直到快指针到达尾部
 *      借助虚拟头结点
 *      时间复杂度O(N) 空间复杂度：O(1)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vHead = new ListNode(0);
        vHead.next = head;

        ListNode fast = head;
        ListNode slow = vHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return vHead.next;
    }
}
