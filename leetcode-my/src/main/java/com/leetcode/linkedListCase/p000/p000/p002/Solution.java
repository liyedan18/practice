package com.leetcode.linkedListCase.p000.p000.p002;


import com.leetcode.linkedListCase.ListNode;

/**
 2. 两数相加

 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers

 思路：
     先遍历完，取出单独数字，然后拼接（用字符串）
     计算完结果后，再查分开，然后逆序存入新链表

    这种方式有问题！！！如果输入的数字超出了Integer或者Long的范围，那么就无法完成计算，造成溢出。
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先遍历完，取出单独数字，然后拼接（用字符串）
        // 计算完结果后，再查分开，然后逆序存入新链表
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(l1 != null){
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            sb2.append(l2.val);
            l2 = l2.next;
        }

        Long sum = Long.parseLong(sb1.reverse().toString()) + Long.parseLong(sb2.reverse().toString());
        char[] chars = sum.toString().toCharArray();
        ListNode node = new ListNode(chars[chars.length - 1] - '0');
        ListNode resNode = node;
        if (chars.length > 1){
            for (int i = chars.length - 2; i >= 0; i--) {
                node.next = new ListNode(chars[i] - '0');
                node = node.next;
            }
        }

        return resNode;
    }
}
