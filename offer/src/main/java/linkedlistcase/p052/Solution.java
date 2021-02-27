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
 *
 * 思路1：
 * 先判断是否有公共节点（最后一个节点是否相同，如果相同，则有公共节点，否则没有）
 * 遍历链表1，放入List。遍历链表2，到List中查询是否存在（==），存在则返回。
 *
 * 这思路太笨了，舍弃
 *
 * 1-2-3-4-5-6-7-8
 *       0-0-9-7-8
 *
 * 思路2：
 * 有公共节点，那么从某个节点开始之后，两个链表的所有元素都是一样的。
 * 怎么找到这个公共节点？
 * 类似快慢双指针的方式。
 * 让长链表先走，等待长链表剩余的长度和短链表相同时，两个指针再一起走。
 * 当两个指针相等，则是相同节点
 *
 * 1.各先遍历一遍，确认各自长度。
 * 2.确认起始节点，开始同时遍历
 *
 */
public class Solution {

    //双指针法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        int countA = 0;
        int countB = 0;

        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }

        ListNode fast;
        ListNode slow;
        if (countA > countB) {
            fast = headA;
            slow = headB;
            while (countA > countB) {
                fast = fast.next;
                countA--;
            }
        } else {
            fast = headB;
            slow = headA;
            while (countB > countA) {
                fast = fast.next;
                countB--;
            }
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
