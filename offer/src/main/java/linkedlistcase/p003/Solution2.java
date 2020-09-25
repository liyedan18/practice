package linkedlistcase.p003;


import java.util.ArrayList;
import java.util.List;

/**
 * 003  输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路2：
 * 递归方法
 *
 * 注意：
 * 输出正序和倒序，采用递归时，正序则在调用递归方法的上面add，倒序，就在调用递归方法的下一行add
 *
 *
 */
public class Solution2 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }

        tailToHead(listNode, list);
        return list;

    }

    private void tailToHead(ListNode listNode, List<Integer> list) {
        //递归的结束条件
        if (listNode == null) {
            return;
        }
        tailToHead(listNode, list);

        //倒叙，则加在tailToHead(listNode, list);后面。正序，则加在tailToHead(listNode, list);前面
        list.add(listNode.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        System.out.println(solution.printListFromTailToHead(list));
    }
}
