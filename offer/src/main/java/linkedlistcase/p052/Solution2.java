package linkedlistcase.p052;


/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 *
 * A:1-2-3-4-5-6-7-8
 * B:      0-0-9-7-8
 *
 * 1-2-3-4-5-6-7-8 -> 0-0-9-7-8
 * 0-0-9-7-8 -> 1-2-3-4-5-6-7-8
 *
 * 思路3：
 * 如上所示，两个链表如果有共同节点，那么这两个链表连起来遍历的话,
 * AB和BA整个链表的后面部分应该是相等的。
 * 则只需要在遍历时判断AB和BA两个链表是否有相等的节点即可。
 *
 */
public class Solution2 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode tempNode1 = pHead1;
        ListNode tempNode2 = pHead2;
        while(tempNode1 != tempNode2){
            if (tempNode1 == null){
                tempNode1 = pHead2;
            } else {
                tempNode1 = tempNode1.next;
            }
            if (tempNode2 == null){
                tempNode2 = pHead1;
            } else {
                tempNode2 = tempNode2.next;
            }

        }

        /**
         * 以上while循环可替换为：
         */
/*        while (tempNode1 != tempNode2){
            tempNode1 = tempNode1 == null ? pHead2 : tempNode1.next;
            tempNode2 = tempNode2 == null ? pHead1 : tempNode2.next;
        }*/

        return tempNode1;

    }

}
