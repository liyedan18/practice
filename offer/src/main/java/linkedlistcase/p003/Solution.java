package linkedlistcase.p003;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 003  输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路1：
 * 正序遍历链表，然后用ArrayList存储。
 * Collections.reverse方法翻转。
 * 最后返回
 *
 */
public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return null;
        }

        do {
            list.add(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        System.out.println(solution.printListFromTailToHead(list));
    }
}
