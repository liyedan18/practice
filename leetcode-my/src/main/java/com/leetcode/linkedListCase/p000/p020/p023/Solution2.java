package com.leetcode.linkedListCase.p000.p020.p023;

import com.leetcode.linkedListCase.ListNode;

import java.util.Arrays;

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
 *      分治法，类似于归并排序
 *      先划分链表数组，直到分成一个一个的链表（类似归并排序，把数组元素都分成一个元素），
 *      再原路合并，合并时比较开头元素
 *
 *      时间复杂度：
 *          在第k次合并后，链表长度为k*n，此时的时间复杂度是 (（1+k）*k/2 )*n =k*k*N
 *      空间复杂度：O(1)
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    //分治到只有一个元素，然后再原路返回继续合并
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >> 1;
        ListNode node1 = merge(lists, left, mid);
        ListNode node2 = merge(lists, mid + 1, right);
        return mergeTwoList(node1, node2);
    }

    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        ListNode temp = new ListNode();
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString("   ss  ss ee   uu  j".split(" ")));
        String s="a good   example";
        if(s==null ||s==""){
            return ;
        }

        String[] str = s.trim().split(" ");
        //反转
        for(int i=0,j=str.length-1;i<j;i++,j--){
            String temp1 = str[i].trim();
            str[i]= str[j].trim();
            str[j]=temp1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length-1;i++){
            if(!str[i].equals("")){
                sb.append(str[i]).append(" ");
            }
        }
        sb.append(str[str.length-1]);

        System.out.println(sb.toString());
    }
}
