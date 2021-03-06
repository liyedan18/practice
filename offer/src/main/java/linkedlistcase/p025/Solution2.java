package linkedlistcase.p025;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *
   思路1：
 * 1->3->5
 * 2->4->6
 * 因为已经排序好了，每次只比较两个队列的头结点即可。那么
 * 1和2比较取1，同时，节点指针往后移动一位。然后剩下：
 * 3->5
 * 2->4->6
 * 这时，2和3比较，取2,同时，节点指针往后移动一位。
 *
 * 重复，直到有其中一个为null.这时注意，两个链表是长短不一样的，剩下的没移动完的链表，
 * 要补在结果链表的后面。
 *
 */
public class Solution2 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        /**
         * 这里注意：想要保存结果链表的头结点
         * 一般是可以创建一个临时链表，然后让临时链表的头结点指向结果链表
         * 然后后面的操作，都由临时链表来执行。最后返回结果链表即可。   引用。
         */
//        ListNode list = null;    //这样不对
//        ListNode tempList = list;

        ListNode list = new ListNode(-50);
        ListNode tempList = list;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tempList.next = list1;
                list1 = list1.next;
            } else {
                tempList.next = list2;
                list2 = list2.next;
            }
            tempList = tempList.next;
        }

        if (list2 != null) {
            tempList.next = list2;
        } else {
            tempList.next = list1;
        }

        return list.next;

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println(solution.Merge(list1, list2).next.val);

    }
}
