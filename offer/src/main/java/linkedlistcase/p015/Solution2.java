package linkedlistcase.p015;

/**
 * 015   题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 *
 * 递归解法
 *
 */
public class Solution2 {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //只有一个节点，直接返回改节点即可
        if (head.next == null) {
            return head;
        }

        //返回反转链表后的头结点
        ListNode res =  ReverseList(head.next);
        //让头节点的下一个节点指向头节点
        head.next.next = head;
        //让头结点的next指向null,作为尾结点
        head.next = null;

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        System.out.println(solution.ReverseList(list).val);

    }
}
