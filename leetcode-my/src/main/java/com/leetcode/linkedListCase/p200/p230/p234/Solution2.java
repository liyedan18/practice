package com.leetcode.linkedListCase.p200.p230.p234;

import com.leetcode.linkedListCase.ListNode;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 *
 * 思路：
 *      双指针技巧，快慢指针找到链表中点
 *      不用额外的存储空间，难题是中点之后的数据与前面是反着的，那就考虑将中点后的链表反转
 *      再开始从头结点和反转后的链表比较
 *
 *      注意：
 *          若是不破坏原来的链表结构，在返回之前，要再次翻转中点后的链表来恢复。
 *          还要记录slow指针的前一个值
 *
 *      时间复杂度：O(n)
 *      空间复杂度：O(1)
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        //快慢指针寻找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //奇数再往前走一步
        if (fast != null) {
            slow = slow.next;
        }

        //翻转slow之后的链表,并记录头结点
        ListNode right = reverse(slow);

        //最后判断是否相等
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    /**
     * 翻转链表
     */
    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
