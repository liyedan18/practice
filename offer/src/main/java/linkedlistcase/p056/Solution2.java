package linkedlistcase.p056;


/**
 * 056   题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&&tqId=11209&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 注意：是要把重复的节点全都删干净，不是留一个
 * 考虑到头节点也可能重复，可以在头节点前面加一个辅助节点。
 *
 * 思路2：最佳
 * a  b   c
 * 遍历同时记录上一个节点a，和当前链表的下一个节点c，删除，即让b指向null，a指向c
 * 注意遍历时，碰到重复的节点，要在本次循环中再嵌入循环来一次全删除干净。
 *
 */
public class Solution2 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        //辅助节点
        ListNode pre = new ListNode(1);
        pre.next = pHead;
        ListNode cur = pHead;
        //记录结果链表头节点
        ListNode res = pre;
        while (cur != null) {
            //有重复节点的条件
            if (cur.next != null && cur.val == cur.next.val) {
                //有连续重复节点，需要一次性全部跳过去
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return res.next;

    }

}
