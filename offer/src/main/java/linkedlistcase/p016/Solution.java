package linkedlistcase.p016;

/**
 * 016   题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *(类似题目：合并k个排序链表，也是利用本题的解法，只不过要进行两两合并)
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 *
 * 思路1：
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
 * 这个结果是错误的，头指针有问题。
 *
 * 参考2和3
 */
public class Solution {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        /**
         * 这里注意：想要保存结果链表的头结点
         * 一般是可以创建一个临时链表，然后让临时链表的头结点指向结果链表
         * 然后后面的操作，都由临时链表来执行。最后返回结果链表即可。   引用。
         * 对比Solution2
         */
        ListNode list = null;
        ListNode resultHead = null;

        if(list1.val <= list2.val){
            list = list1;
            list1 = list1.next;
        } else {
            list = list2;
            list2 = list2.next;
        }
        resultHead = list;
        list = list.next;

        while(list1!=null && list2 !=null){
            if(list1.val <= list2.val){
                list = list1;
                list1 = list1.next;
            } else {
                list = list2;
                list2 = list2.next;
            }
            list = list.next;
        }

        if (list2 != null){
            list = list2;
        } else {
            list = list1;
        }

        return resultHead;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println(solution.Merge(list1, list2).val);

    }
}
