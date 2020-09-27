package linkedlistcase.p014;



/**
 * 014 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 最佳思路3 Solution2：
 * 双指针——同向快指针和慢指针
 * 倒数第k个，也即是正数第count-k个
 * 快指针一直比慢指针快K-1个节点，当快指针到达链表尾时，慢指针刚好是倒数第k个
 * 快指针先行k-1步,从第k步开始，慢指针开始跟上
 *
 * 复杂度O(n)，一次遍历即可。且不需要额外空间
 */
public class Solution3 {

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode nodeK = null;
        if (head == null || k <= 0) {
            return nodeK;
        }

        ListNode fast = head;
        ListNode slow = head;  //第k步
        int count = 1;
        while(fast.next != null){
            fast = fast.next;
            count ++;

            if(count >= k+1){
                slow = slow.next;  //第k+1步
            }
        }

        //如果k超出了范围，包括大于最大值和小于最小值，则返回空
        if (count < k){
            return nodeK;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        System.out.println(solution.FindKthToTail(list, 5).val);
    }
}
