package com.leetcode.linkedListCase.p200.p230.p234;

import com.leetcode.linkedListCase.ListNode;

import java.util.ArrayList;
import java.util.List;

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
 *      同时用List存储慢指针走过的元素（再反转）
 *      然后慢指针继续走，同时和list的元素比较
 *
 *      时间复杂度：O(n)
 *      空间复杂度：O(n/2)
 *
 *      也可以用后序遍历递归实现
 *      时间复杂度：O(n)
 *      空间复杂度：O(n)
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        //快慢指针找中点
        List<Integer> list = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            list.add(slow.val);
            slow = slow.next;
        }

        //奇数节点,slow再往前走一步
        if (fast != null) {
            slow = slow.next;
        }

        //slow已经到达中点，开始比较
        int index = list.size() - 1;
        while (slow != null) {
            if (slow.val != list.get(index)) {
                return false;
            }
            slow = slow.next;
            index--;
        }

        return true;
    }
}
