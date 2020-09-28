package linkedlistcase.p055;


/**
 * 055   给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&&tqId=11208&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 首先判断是否有环
 * 然后再看环的入口节点
 *
 * 最佳思路1：
 * 不需要额外的空间消耗
 *
 * 快慢指针—— 快指针是慢指针速度的2倍
 *
 * 首先判断是否有环：
 *     如果两个指针相遇，则说明有环。并记录
 *
 * 然后再看环的入口节点
 *     这时需要两个相同速度的指针，一个从刚才相遇的节点走，一个从链表起始节点走，
 *     那么他们相遇的节点，就是链表的入口节点
 *
 *参考：
 * https://mp.weixin.qq.com/s/NuxffdWZlzK2tWsTUIXfZQ
 *
 */
public class Solution {


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        //判断有环
//        while (fast != null && slow != null) {
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //无环
        if (fast == null || fast.next == null) {
            return null;
        }

        //计算环入口节点
        //入口节点一定是slow和start相遇的节点。
        ListNode start = pHead;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        return start;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
//        System.out.println(solution.EntryNodeOfLoop(list));

    }
}
