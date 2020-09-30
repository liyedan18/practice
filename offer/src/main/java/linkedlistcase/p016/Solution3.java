package linkedlistcase.p016;

/**
 * 016   题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
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
 *
 * 思路2 ：
 * 递归
 * 上面重复的过程，其实是递归问题。
 *
 * 递归问题的通用处理模板：
 * 1.递归方法的结束条件是什么？
 * 2.递归方法每进行一次，范围（递归区间）一定是缩小的，那下一次的范围是什么。
 *
 *     1的答案：结束条件是链表为null，和思路1一样
 *     2的答案：下一次的范围也就是思路1的while循环的内容
 *
 */
public class Solution3 {

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
        Solution3 solution = new Solution3();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println(solution.Merge(list1, list2).next.val);

    }
}
