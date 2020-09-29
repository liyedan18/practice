package linkedlistcase.p015;

/**
 * 015   题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 从头开始遍历，然后让后一个节点的next指向前一个节点。
 * 同时，需要一个临时变量来保存中间下一个下一个节点的指针。
 *
 * newList=null
 * A->B->C->NULL
 *
 * A->newList  B->C->NULL     newList->A->null
 * B->newList  C->NULL        newList->B->A->null
 *
 *
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = null;
        ListNode newList = null;
        while (head != null) {
            temp = head.next;
            head.next = newList;
            newList = head;
            head = temp;
        }

        return newList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        System.out.println(solution.ReverseList(list).val);

    }
}
