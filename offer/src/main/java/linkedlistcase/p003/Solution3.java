package linkedlistcase.p003;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 003  输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路3：
 * 倒叙，利用栈FILO特性
 *
 */
public class Solution3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }

        //先压入栈
        Stack<Integer> stack = new Stack<>();
        do {
            stack.push(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);

        //再弹出栈
        while (!stack.empty()){
            list.add(stack.pop());
        }

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
