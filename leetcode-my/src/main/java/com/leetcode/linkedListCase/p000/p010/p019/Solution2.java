package com.leetcode.linkedListCase.p000.p010.p019;

import com.leetcode.linkedListCase.ListNode;

import java.util.Stack;

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
 *      倒数的问题，用栈特点，先进后出
 *      时间复杂度O(N) 空间复杂度：O(N)
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode temp = vhead;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return vhead.next;
    }
}
