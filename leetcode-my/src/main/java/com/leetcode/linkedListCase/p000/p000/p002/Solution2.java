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

 正确思路：
     一位一位的对应相加，并记录进位，也就是
     个位 + 个位 + 进位 = 个位的数值 + 十位的进位
     十位 + 十位 + 进位 = 十位的数值 + 百位的进位   ...
     2 -> 4 -> 3
     5 -> 6 -> 4
     如果对应位置 加数 为空，则+0即可
     题目中刚好是逆序的

 */

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //添加辅助头结点
        ListNode resNode = new ListNode(0);
        //其实引用的是头结点
        ListNode returnNode = resNode;

        //进位
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int temp1 = 0;
            int temp2 = 0;
            if (l1 != null){
                temp1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                temp2 = l2.val;
                l2 = l2.next;
            }

            int sum = temp1 + temp2;
            //注意 9+0+1=10的情况
            if ((sum % 10 + carry) <= 9) {
                resNode.next = new ListNode(sum % 10 + carry);
                carry = sum / 10;
            } else {
                resNode.next = new ListNode(0);
                carry = 1;
            }
            resNode = resNode.next;
        }

        return returnNode.next;
    }
}
