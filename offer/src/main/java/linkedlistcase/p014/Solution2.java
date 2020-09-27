package linkedlistcase.p014;


/**
 * 014 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路2：
 * 递归，递归到最后一个时，开始计数count++,count=k时，跳出递归，返回对应的节点。
 * 递归不可行。因为head节点一直在变化。
 *
 * 复杂，抛弃！！！
 *
 */
public class Solution2 {

    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode nodeK = null;
        if (head == null || k <= 0) {
            return nodeK;
        }

        Integer countK = 0;
        Integer total = 0;
        findNode(head, k, countK, total, nodeK);

        return nodeK;
    }

    public void findNode(ListNode head,int k, Integer countK, Integer total, ListNode resultNode){
        if(head == null || k > total){
            return;
        }
        total++;
        head = head.next;

        findNode(head, k, countK, total, resultNode);

        if(k > total){
            return;
        }
        countK++;
        if (k == ++countK){
            /**
             * 这里的head随着递归的进行，已经变化了
             */
            resultNode = head;
        }
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
