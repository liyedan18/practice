package com.leetcode.linkedListCase.p200.p230.p237;


import com.leetcode.linkedListCase.ListNode;

/**
 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 示例 1：

 输入：head = [4,5,1,9], node = 5
 输出：[4,1,9]
 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2：

 输入：head = [4,5,1,9], node = 1
 输出：[4,5,9]
 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list


 提示：

 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。


 思路：
 1.从头结点找到前一个节点，然后将前一个节点的next指向要删除节点的next
 缺点：
 要遍历，题目中没给头结点。因此不能遍历

 最优解：
 不需要找前一个节点，可以将要删除的节点的值用下一个节点的值覆盖，然后
 将要删除的节点的next指向下一个节点的next即可。

 */

public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
