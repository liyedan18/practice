package linkedlistcase.p014;


import java.util.ArrayList;
import java.util.List;

/**
 * 014 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 思路1：
 * 将单链表节点转换为数组节点，然后求倒数第K个数据。（空间消耗大，占用内存: 9652KB）
 * (注：也可以直接求正数第count-k个node，循环两次即可，第一次先判断链表长度，
 * 第二次求正数第count-k个node)
 *
 * 最佳思路3 Solution3：
 * 双指针——同向快指针和慢指针
 * 倒数第k个，也即是正数第count-k个
 * 快指针一直比慢指针快K个节点，当快指针到达链表尾时，慢指针刚好是倒数第k个
 */
public class Solution {

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode nodeK = null;
        if (head == null || k <= 0) {
            return nodeK;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        //如果k超出了范围，包括大于最大值和小于最小值，则返回空
        if (k > list.size()) {
            return nodeK;
        }

        return list.get(list.size() - k);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        System.out.println(solution.FindKthToTail(list, 2).val);
    }
}
